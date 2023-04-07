package Models;

public class Skill {
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


    public Skill(String name, EvoType type, Range range, int pwr, int acc, int hits, int turns, int delay, int rest,
            int crit, int recoil, int extraDmg, Stats dmgStat, Stats effectStat, int statChange, int statChance,
            int effectChance, Conditions condition) {
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


    public Skill(SkillList skill) {
        this.name           = skill.name;
        this.type           = skill.type;
        this.range          = skill.range;
        this.pwr            = skill.pwr;
        this.acc            = skill.acc;
        this.hits           = skill.hits;
        this.turns          = skill.turns;
        this.delay          = skill.delay;
        this.rest           = skill.rest;
        this.crit           = skill.crit;
        this.recoil         = skill.recoil;
        this.extraDmg       = skill.extraDmg;
        this.dmgStat        = skill.dmgStat;
        this.effectStat     = skill.effectStat;
        this.statChange     = skill.statChange;
        this.statChance     = skill.statChance;
        this.effectChance   = skill.effectChance;
        this.condition      = skill.condition;
    }

    

    

    

}
