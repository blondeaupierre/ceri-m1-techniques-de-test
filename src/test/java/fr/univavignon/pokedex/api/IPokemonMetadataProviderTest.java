package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {


    private static IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    private static List<PokemonMetadata> pokemonMetadatas;

    @BeforeAll
    public static void setUp() throws PokedexException {

        pokemonMetadatas = new ArrayList<>();

        PokemonMetadata pokemonMetadata1 = mock(PokemonMetadata.class);
        when(pokemonMetadata1.getIndex()).thenReturn(1);
        when(pokemonMetadata1.getName()).thenReturn("Bulbasaur");
        when(pokemonMetadata1.getAttack()).thenReturn(126);
        when(pokemonMetadata1.getDefense()).thenReturn(126);
        when(pokemonMetadata1.getStamina()).thenReturn(90);

        pokemonMetadatas.add(pokemonMetadata1);

        pokemonMetadataProvider = new PokemonMetadataProvider(pokemonMetadatas);
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
