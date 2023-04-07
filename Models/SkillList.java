package Models;

import java.util.concurrent.locks.Condition;

public enum SkillList {
    SLAP    ("Slap",    EvoType.NORMAL,Range.MELEE,     30, 100,1,1,0,0,0,0,0,Stats.pATK, null,       0,  0,  0,  null),
    DEBUFF  ("Debuff",  EvoType.NORMAL,Range.RANGED,    0,  100,0,1,0,0,0,0,0,null,       Stats.pATK, 10, 10, 100,null),
    BUFF    ("Buff",    EvoType.NORMAL,Range.SELF,      0,  100,0,1,0,0,0,0,0,null,       Stats.pATK, 10, 10, 100,null),
    SPECIAL ("Special", EvoType.NORMAL,Range.RANGED,    50, 100,1,1,0,0,0,0,0,Stats.sATK, null,       0,  0,  0,  null);

    String name;
    EvoType type;
    Range range;
    int pwr;
    int acc;
    int hits;
    int turns;
    int delay;
    int rest;
    int crit;
    int recoil;
    int extraDmg;
    Stats dmgStat;
    Stats effectStat;
    int statChange;
    int statChance;
    int effectChance;
    Conditions condition;

    private SkillList(String name, EvoType type, Range range, int pwr, int acc, int hits, int turns, int delay,
            int rest, int crit, int recoil, int extraDmg, Stats dmgStat, Stats effectStat, int statChange,
            int statChance, int effectChance, Conditions condition) {
        this.name = name;
        this.type = type;
        this.range = range;
        this.pwr = pwr;
        this.acc = acc;
        this.hits = hits;
        this.turns = turns;
        this.delay = delay;
        this.rest = rest;
        this.crit = crit;
        this.recoil = recoil;
        this.extraDmg = extraDmg;
        this.dmgStat = dmgStat;
        this.effectStat = effectStat;
        this.statChange = statChange;
        this.statChance = statChance;
        this.effectChance = effectChance;
        this.condition = condition;
    }

}
