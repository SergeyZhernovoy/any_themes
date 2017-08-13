package knights_2_example_DI;

import part2_3.knights_2_example_DI.BraveKnights;
import part2_3.knights_2_example_DI.Quest;
import part2_3.knigths_1.QuestException;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * @author Sergey Zhernovoy
 *         create on 02.08.2017.
 */
public class BraveKnightsTest {

    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException{
        Quest mockQuest = mock(Quest.class);
        BraveKnights braveKnights = new BraveKnights(mockQuest);
        braveKnights.embarkOnQuest();
        verify(mockQuest,times(1)).embark();

    }

}