package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private static IPokemonFactory pokemonFactory;

    @Mock
    private static Pokemon pokemon;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokemonFactory = new PokemonFactory();

        pokemon = mock(Pokemon.class);
        when(pokemon.getIndex()).thenReturn(1);
        when(pokemon.getName()).thenReturn("Bulbasaur");
        when(pokemon.getCp()).thenReturn(613);
        when(pokemon.getHp()).thenReturn(64);
        when(pokemon.getDust()).thenReturn(4000);
        when(pokemon.getCandy()).thenReturn(4);

    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getIndex(), 1);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getCp(), 613);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getHp(), 64);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getDust(), 4000);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getCandy(), 4);
    }
}
