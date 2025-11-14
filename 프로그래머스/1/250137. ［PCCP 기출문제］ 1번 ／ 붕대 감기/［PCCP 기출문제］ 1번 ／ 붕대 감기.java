class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int castTime = bandage[0];  // 연속 시전 시간
        int healPerSec = bandage[1]; // 초당 회복량
        int bonusHeal = bandage[2];  // 시전 성공 보너스 회복량

        int maxHealth = health;
        int hp = health;

        int continuous = 0;          // 연속 시전 카운트
        int attackIndex = 0;        // 공격 배열 포인터    
        int lastAttackTime = attacks[attacks.length - 1][0];

        for (int time = 1; time <= lastAttackTime; time++) {

            /** 0. 회복 단계 — 공격보다 먼저 처리 */
            if (attackIndex < attacks.length && attacks[attackIndex][0] != time) {
                continuous++;
                hp += healPerSec;
                
                if (continuous == castTime) {
                    hp += bonusHeal;
                    continuous = 0;
                }
                
                // 최대 체력 초과 방지
                if (hp > maxHealth) {
                    hp = maxHealth;
                }
            } 


            /** 1. 공격 존재 여부 체크 */
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                // 즉시 데미지
                hp -= attacks[attackIndex][1];
                // 시전 끊김
                continuous = 0; 
                attackIndex++;
            }

            /** 2. 사망 체크 */
            if (hp <= 0){
                return -1;
            }
                
        }

        
        return hp;
    }
}