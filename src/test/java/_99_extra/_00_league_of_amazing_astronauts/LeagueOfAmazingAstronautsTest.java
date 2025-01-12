package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.LeagueOfAmazingAstronauts;
import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {

    LeagueOfAmazingAstronauts underTest = new LeagueOfAmazingAstronauts();
    @Mock
	Rocketship rocket;
	@Mock 
	Astronaut astro;
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    }

    @Test
    void itShouldPrepareAstronaut() {
        //given
    	
        //when
    	when(astro.isTrained()).thenReturn(true);
    	underTest.prepareAstronaut(astro);
        //then
    	verify(astro, times(1)).train();
    }

    @Test
    void itShouldLaunchRocket() {
        //given
    	String dest = "Mars";
        //when
    	when(astro.isTrained()).thenReturn(true);
    	underTest.launchRocket(dest);
        //then
    	assertEquals(underTest.rocketship.rocketsIgnited, true);
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
    	String s = "somewhere";
    	
        //when
    	when(astro.isTrained()).thenReturn(true);
        //then
    	
    	Throwable ex = assertThrows(IllegalArgumentException.class, ()->underTest.launchRocket(s));
    	assertEquals(ex.getMessage(), "Destination is unavailable");
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
    	String dest = "Mars";
        //when
    	when(astro.isTrained()).thenReturn(true);
    	Astronaut rockAstro = underTest.rocketship.getAstronaut();
    	rockAstro = null;
        //then
    	Throwable ex = assertThrows(IllegalStateException.class, ()-> underTest.launchRocket(dest));
    	assertEquals(ex.getMessage(), "Rocketship is not loaded");
    }
}