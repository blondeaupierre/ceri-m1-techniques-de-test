package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    // Comment tester inteface qui n'a pas d'implémentations ?
    @Mock
    private static IPokedex pokedex;

    @Mock
    private static Pokemon pokemon;

    @BeforeAll
    public static void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 2500, 2, 0.91);
        when(pokedex.size()).thenReturn(4);
        when(pokedex.getPokemon(1)).thenReturn(pokemon);
        when(pokedex.addPokemon(pokemon)).thenReturn(pokemon.getIndex());
        when(pokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
        when(pokedex.getPokemons(null)).thenReturn(new ArrayList<Pokemon>());
    }

    @Test
    public void testSize() {
        assertEquals(pokedex.size(), 4);
    }

    @Test
    public void testAddPokedex() {
        assertEquals(pokedex.addPokemon(pokemon), pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokedex.getPokemon(1), pokemon);
    }

    @Test
    public void testGetPokemons() {
        assertEquals(pokedex.getPokemons(), new ArrayList<Pokemon>());
    }

    @Test
    public void testGetPokemonsWithOrder() {
        assertEquals(pokedex.getPokemons(null), new ArrayList<Pokemon>());
    }
}
