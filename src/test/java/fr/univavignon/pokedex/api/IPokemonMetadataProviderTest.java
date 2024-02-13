package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private static PokemonMetadata pokemonMetadata;

    @BeforeAll
    public static void setUp() {
        pokemonMetadata = new PokemonMetadata(1, "ulbasaur", 126, 126, 90);
    }
    @Test
    public void testGetName() {
        assertEquals(pokemonMetadata.getName(), "Bulbasaur");
    }

    @Test
    public void testGetAttack() {
        assertEquals(pokemonMetadata.getAttack(), 126);
    }

    @Test
    public void testGetDefense() {
        assertEquals(pokemonMetadata.getDefense(), 126);
    }

    @Test
    public void testGetStamina() {
        assertEquals(pokemonMetadata.getStamina(), 90);
    }

    @Test
    public void testGetIndex() {
        assertEquals(pokemonMetadata.getIndex(), 1);
    }
}
