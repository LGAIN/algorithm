import subprocess
import re

README_PATH = "README.md"

def get_commit_logs():
    result = subprocess.run(
        ["git", "log", "--pretty=format:%s"], capture_output=True, text=True
    )
    return result.stdout.strip().split("\n")

def parse_commit_message(msg):
    # 난이도: Bronze ~ Ruby + 로마 숫자 (I~V)
    match = re.match(r"\[(\d{6})\]\s+(.*?)\s+\|\s+(.*?)\s+\|\s+(Bronze|Silver|Gold|Platinum|Diamond|Ruby|Unrated)\s+[IVX]+", msg)
    if match:
        parts = re.split(r"\s+\|\s+", msg[8:])  # 날짜 이후부터 분리
        if len(parts) == 3:
            title, category, level = parts
            date = msg[1:7]
            return f"| {date} | {title} | {category} | {level} |"
    return None

def insert_into_readme(lines):
    with open(README_PATH, "r") as f:
        content = f.readlines()

    new_table = ["| 날짜    | 문제 이름 | 유형 | 난이도 |\n", "|---------|-----------|------|--------|\n"]
    new_table += lines

    with open(README_PATH, "w") as f:
        for line in content:
            if line.strip().startswith("| 날짜"):
                break
            f.write(line)
        f.writelines(new_table)

if __name__ == "__main__":
    commits = get_commit_logs()
    parsed = list(filter(None, [parse_commit_message(msg) + "\n" for msg in commits]))
    parsed = list(dict.fromkeys(parsed))  # 중복 제거
    insert_into_readme(parsed)