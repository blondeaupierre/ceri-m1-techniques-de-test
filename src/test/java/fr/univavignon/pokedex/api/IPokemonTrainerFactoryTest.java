package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private static IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    private static IPokedexFactory pokedexFactory;

    @Mock
    private static IPokedex pokedex;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        pokemonTrainerFactory = new PokemonTrainerFactory();
  }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("equipe", Team.VALOR, pokedexFactory);
        assertNotNull(trainer);
    }

    @Test
    public void testGetName() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("equipe", Team.VALOR, pokedexFactory);
        assertEquals("equipe", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("equipe", Team.VALOR, pokedexFactory);
        assertEquals(Team.VALOR, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("equipe", Team.VALOR, pokedexFactory);
        assertEquals(pokedex, trainer.getPokedex());
    }
}
