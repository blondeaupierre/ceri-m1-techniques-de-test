package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    @Mock
    private static IPokedexFactory pokedexFactory;
    @Mock
    private static IPokemonMetadataProvider pokemonMetadataProvider;
    @Mock
    private static IPokemonFactory pokemonFactory;
    @Mock
    private static IPokedex pokedex;

    @BeforeAll
    public static void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory), pokedex);
    }
}