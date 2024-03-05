package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private static IPokemonTrainerFactory pokemonTrainerFactory;

    @Mock
    private static IPokedexFactory pokedexFactory;

    @Mock
    private static IPokedex pokedex;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        when(pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory)).thenReturn(new PokemonTrainer("baka", Team.VALOR, pokedex));
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory);
        assertEquals(pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory), trainer);
    }

    @Test
    public void testGetName() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory);
        assertEquals("baka", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory);
        assertEquals(Team.VALOR, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("baka", Team.VALOR, pokedexFactory);
        assertEquals(pokedex, trainer.getPokedex());
    }
}
