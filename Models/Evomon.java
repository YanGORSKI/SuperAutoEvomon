package Models;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import javafx.scene.Node;

public class Evomon {
    String name;
    EvoType type;                   //Tipo:: determina as forças e fraquezas
    int form;                       //Forma:: estágio de evolução
    int evos;                       //Evoluções::numero de evoluções
    int tier;                       //Tier de Loja:: depende do quão forte ele é, ele vai demorar mais ou menos pra aparecer na loja
    int lvl;                        //Level:: Level da Forma atual
    int maxLvl;                     //Level Máximo da Forma:: Todos tem 10 LvL, mas eles são distribuídos entre as Formas

    Stat hp;                        //Health Pts:: chegou a 0, morreu
    Stat sp;                        //Special Pts:: chegou a 100, usa o Golpe4
    Stat focus;                     //Taxa de ganho de SP:: qnto de SP ganha por tick
    Stat pAtk;                      //Physical Attack:: mod de força física
    Stat pDef;                      //Physical Defense:: mod de defesa física
    Stat sAtk;                      //Special Attack:: mod de força special
    Stat sDef;                      //Special Defense:: mod de defesa special
    Stat init;                      //Initiative:: medidor de iniciativa, chegou a 100 faz ação
    Stat spd;                       //Speed:: taxa de ganho de init
    Stat evs;                       //Evasion:: % de evasão
    Stat acc;                       //Accuracy:: % de acerto
    Stat crit;                      //Critical:: % de chance de acerto critico

    Skill skill_1;                  //1st Skill:: 40% chance de usar
    Skill skill_2;                  //2nd Skill:: 30% chance de usar
    Skill skill_3;                  //3rd Skill:: 20% chance de usar
    Skill skill_4;                  //4th Skill:: 10% chance de usar

    Skill activeSkill;              //Active Skill:: habilidade ativa
    int actvSkillTurns;             //Turns:: turnos que a Skill ja esta ativa
    int actvSkillMaxTurns;          //Max Turns:: máximo de turnos que a Skill fica ativa
    int actvSkillDelay;             //Delay:: turns de espera antes de realizar o efeito da Skill
    int actvSkillRest;              //Rest:: turns de espera depois do efeito da Skill

    int inactiveTurns;              //Inactive Turns:: turnos a se ficar inativo por qlqr efeito

    Skill lastUsedSkill;            //Ultima Skill usada
    Skill lastSufferedSkill;        //Ultima Skill sofrida

    Evomon target;                  //Alvo

    AbilityList ability;                //Habilidade Passiva

    Item heldItem;                  //Item equipado

    ArrayList<Condition> conditions = new ArrayList<Condition>();
    ArrayList<Stat> coreStats = new ArrayList<Stat>();

    String sprite;

    

    public Evomon(EvomonList evomon) {
        this.name       = evomon.name;
        this.type       = evomon.type;
        this.form       = evomon.form;
        this.evos       = evomon.evos;
        this.tier       = evomon.tier;
        this.hp         = new Stat(Stats.HP, evomon.hp);
        this.sp         = new Stat(Stats.SP, 0);
        this.focus      = new Stat(Stats.FCS, evomon.focus);
        this.pAtk       = new Stat(Stats.pATK, evomon.pAtk);
        this.pDef       = new Stat(Stats.pDEF, evomon.pDef);
        this.sAtk       = new Stat(Stats.sATK, evomon.sAtk);
        this.sDef       = new Stat(Stats.sDEF, evomon.sDef);
        this.spd        = new Stat(Stats.SPD, evomon.spd);
        this.init       = new Stat(Stats.INIT, 0);
        this.evs        = new Stat(Stats.EVS, evomon.evs);
        this.acc        = new Stat(Stats.ACC, evomon.acc);
        this.crit       = new Stat(Stats.CRIT, evomon.crit);
        this.skill_1    = new Skill(evomon.skill_1);
        this.skill_2    = new Skill(evomon.skill_2);
        this.skill_3    = new Skill(evomon.skill_3);
        this.skill_4    = new Skill(evomon.skill_4);
        this.ability    = evomon.ability;
        this.sprite     = evomon.sprite;
    }



    @Override
    public String toString() {
        return "Evomon [name=" + name + ", type=" + type + ", form=" + form + ", evos=" + evos + ", tier=" + tier
                + ", lvl=" + lvl + ", maxLvl=" + maxLvl + ", hp=" + hp + ", sp=" + sp + ", focus=" + focus + ", pAtk="
                + pAtk + ", pDef=" + pDef + ", sAtk=" + sAtk + ", sDef=" + sDef + ", init=" + init + ", spd=" + spd
                + ", evs=" + evs + ", acc=" + acc + ", crit=" + crit + ", skill_1=" + skill_1 + ", skill_2=" + skill_2
                + ", skill_3=" + skill_3 + ", skill_4=" + skill_4 + ", activeSkill=" + activeSkill + ", actvSkillTurns="
                + actvSkillTurns + ", actvSkillMaxTurns=" + actvSkillMaxTurns + ", actvSkillDelay=" + actvSkillDelay
                + ", actvSkillRest=" + actvSkillRest + ", inactiveTurns=" + inactiveTurns + ", lastUsedSkill="
                + lastUsedSkill + ", lastSufferedSkill=" + lastSufferedSkill + ", target=" + target + ", ability="
                + ability + ", heldItem=" + heldItem + ", conditions=" + conditions + ", coreStats=" + coreStats + "]";
    }



    public String getName() {
        return name;
    }



    public EvoType getType() {
        return type;
    }



    public int getForm() {
        return form;
    }



    public int getEvos() {
        return evos;
    }



    public int getTier() {
        return tier;
    }



    public int getLvl() {
        return lvl;
    }



    public int getMaxLvl() {
        return maxLvl;
    }



    public Stat getHp() {
        return hp;
    }



    public Stat getSp() {
        return sp;
    }



    public Stat getFocus() {
        return focus;
    }



    public Stat getpAtk() {
        return pAtk;
    }



    public Stat getpDef() {
        return pDef;
    }



    public Stat getsAtk() {
        return sAtk;
    }



    public Stat getsDef() {
        return sDef;
    }



    public Stat getInit() {
        return init;
    }



    public Stat getSpd() {
        return spd;
    }



    public Stat getEvs() {
        return evs;
    }



    public Stat getAcc() {
        return acc;
    }



    public Stat getCrit() {
        return crit;
    }



    public Skill getSkill_1() {
        return skill_1;
    }



    public Skill getSkill_2() {
        return skill_2;
    }



    public Skill getSkill_3() {
        return skill_3;
    }



    public Skill getSkill_4() {
        return skill_4;
    }



    public Skill getActiveSkill() {
        return activeSkill;
    }



    public int getActvSkillTurns() {
        return actvSkillTurns;
    }



    public int getActvSkillMaxTurns() {
        return actvSkillMaxTurns;
    }



    public int getActvSkillDelay() {
        return actvSkillDelay;
    }



    public int getActvSkillRest() {
        return actvSkillRest;
    }



    public int getInactiveTurns() {
        return inactiveTurns;
    }



    public Skill getLastUsedSkill() {
        return lastUsedSkill;
    }



    public Skill getLastSufferedSkill() {
        return lastSufferedSkill;
    }



    public Evomon getTarget() {
        return target;
    }



    public AbilityList getAbility() {
        return ability;
    }



    public Item getHeldItem() {
        return heldItem;
    }



    public ArrayList<Condition> getConditions() {
        return conditions;
    }



    public ArrayList<Stat> getCoreStats() {
        return coreStats;
    }



    public String getSprite() {
        return sprite;
    }



    public void increaseInitiative(double elapsedSeconds) {
        this.init.setMod((int)((this.init.getMod() + this.spd.getCurrent())*elapsedSeconds));
        this.init.updateCurrent();
        if (this.init.getCurrent() >= 100) {
            // this.act();
        }
        this.init.setMod(this.init.getCurrent()-100);
        this.init.updateCurrent();
    }

    
}
