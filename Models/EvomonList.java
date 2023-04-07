package Models;

public enum EvomonList {
    BREEZOWL    ("Breezowl", EvoType.AIR,1,4,1,40,40,30,65,35,25,50,10,105,10,SkillList.SLAP,SkillList.DEBUFF,SkillList.BUFF,SkillList.SPECIAL,AbilityList.STRUGGLE, "Resources\\Sprites\\Breezowl_Sprite.png"),
    DUSTILLO    ("Dustillo", EvoType.EARTH,1,4,1,60,30,65,15,40,55,40,-10,110,5,SkillList.SLAP,SkillList.DEBUFF,SkillList.BUFF,SkillList.SPECIAL,AbilityList.STRUGGLE, ""),
    SCARFUR     ("Scarfur", EvoType.FIRE,1,4,1,40,55,30,55,30,40,50,5,100,5,SkillList.SLAP,SkillList.DEBUFF,SkillList.BUFF,SkillList.SPECIAL,AbilityList.STRUGGLE, "Resources\\Sprites\\Scarfur_Sprite.png"),
    WOLFARK     ("Wolfark", EvoType.LIGHTNING,1,4,1,30,55,30,65,30,10,70,15,95,10,SkillList.SLAP,SkillList.DEBUFF,SkillList.BUFF,SkillList.SPECIAL,AbilityList.STRUGGLE, ""),
    DEWCKO      ("Dewcko", EvoType.WATER,1,4,1,50,30,35,50,45,40,50,5,100,5,SkillList.SLAP,SkillList.DEBUFF,SkillList.BUFF,SkillList.SPECIAL,AbilityList.STRUGGLE, "");

    String name;
    EvoType type;

    int form;
    int evos;
    int tier;

    int hp;
    int fcs;
    int pAtk; 
    int pDef; 
    int sAtk; 
    int sDef; 
    int focus;
    int spd;
    int evs;
    int acc;
    int crit; 

    SkillList skill_1;
    SkillList skill_2;
    SkillList skill_3;
    SkillList skill_4;

    AbilityList ability;

    String sprite;

    private EvomonList() {
    }

    private EvomonList( String name, EvoType type,
                        int form,   int evos,   int tier,
                        int hp,     int pAtk,   int pDef,   int sAtk,
                        int sDef,   int focus,  int spd,    int evs,
                        int acc, int crit,
                        SkillList skill_1, SkillList skill_2, SkillList skill_3,
                        SkillList skill_4, AbilityList ability, String sprite) {
        this.name       = name;
        this.type       = type;
        this.form       = form;
        this.evos       = evos;
        this.tier       = tier;
        this.hp         = hp;
        this.pAtk       = pAtk;
        this.pDef       = pDef;
        this.sAtk       = sAtk;
        this.sDef       = sDef;
        this.focus      = focus;
        this.spd        = spd;
        this.evs        = evs;
        this.acc        = acc;
        this.crit       = crit;
        this.skill_1    = skill_1;
        this.skill_2    = skill_2;
        this.skill_3    = skill_3;
        this.skill_4    = skill_4;
        this.ability    = ability;
        this.sprite     = sprite;
    }


}
