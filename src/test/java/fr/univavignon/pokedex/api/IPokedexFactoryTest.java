package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private static IPokedexFactory pokedexFactory;
    @Mock
    private static IPokemonMetadataProvider pokemonMetadataProvider;
    @Mock
    private static IPokemonFactory pokemonFactory;
    @Mock
    private static IPokedex pokedex;

    @BeforeAll
    public static void setUp() {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);

        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}