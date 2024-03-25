package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IRocketPokemonFactoryTest {

    private static IPokemonFactory pokemonFactory;

    @Mock
    private static Pokemon pokemon;

    @Mock
    private static IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
        pokemonFactory = new PokemonFactory(pokemonMetadataProvider);

        pokemonFactory = new RocketPokemonFactory(); // RoketPokemonFactoru

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
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getIndex(), pokemon.getIndex());
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getCp(), pokemon.getCp());
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getHp(), pokemon.getHp());
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getDust(), pokemon.getDust());
        assertEquals(pokemonFactory.createPokemon(1, 613, 64, 4000, 4).getCandy(), pokemon.getCandy());
    }
}
