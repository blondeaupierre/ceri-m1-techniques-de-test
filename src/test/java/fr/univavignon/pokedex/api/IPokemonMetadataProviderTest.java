package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private static IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));

    }
    @Test
    public void testGetName() throws PokedexException {
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(1).getName(), "Bulbasaur");
    }
    @Test
    public void testGetAttack() throws PokedexException {
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(1).getAttack(), 126);
    }

    @Test
    public void testGetDefense() throws PokedexException {
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(1).getDefense(), 126);
    }

    @Test
    public void testGetStamina() throws PokedexException {
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(1).getStamina(), 90);
    }

    @Test
    public void testGetIndex() throws PokedexException {
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(1).getIndex(), 1);
    }
}
