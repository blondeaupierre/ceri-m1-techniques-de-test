package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    private static IPokemonFactory pokemonFactory;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(1, 613, 64, 4000, 4)).thenReturn(new Pokemon(1, "Bulbasaur", 613, 64, 4000, 4, 4000, 4, 4, 4));
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4), pokemon);
    }
}
