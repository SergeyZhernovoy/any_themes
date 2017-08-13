package part2_3.knigths_1;/**
 * @author Sergey Zhernovoy
 * create on 02.08.2017.
 */

/**
 * Сценарий : Рыцарь спасает даму
 *
 */

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight(RescueDamselQuest quest){
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() throws QuestException{
        quest.embark();
    }


}

    