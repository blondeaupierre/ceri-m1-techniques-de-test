package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

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
        assertEquals(4, pokedex.size());
    }

    @Test
    public void testAddPokedex() {
        assertEquals(pokedex.addPokemon(pokemon), pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokedex.getPokemon(1), pokemon);
        assertEquals(pokedex.getPokemon(1).getIndex(), 1);
        assertEquals(pokedex.getPokemon(1).getName(), "Bulbizarre");
        assertEquals(pokedex.getPokemon(1).getAttack(), 126);
        assertEquals(pokedex.getPokemon(1).getDefense(), 126);
        assertEquals(pokedex.getPokemon(1).getStamina(), 90);
        assertEquals(pokedex.getPokemon(1).getCp(), 613);
        assertEquals(pokedex.getPokemon(1).getHp(), 64);
        assertEquals(pokedex.getPokemon(1).getDust(), 2500);
        assertEquals(pokedex.getPokemon(1).getCandy(), 2);
        assertEquals(pokedex.getPokemon(1).getIv(), 0.91);
    }

    @Test
    public void testThrowsGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenThrow(new PokedexException("Invalid index"));
        try {
            pokedex.getPokemon(-10);
        } catch (PokedexException e) {
            assertEquals(e.getMessage(), "Invalid index");
        }
    }

    @Test
    public void testGetPokemons() {
        assertEquals(pokedex.getPokemons(), new ArrayList<Pokemon>());
    }

    @Test
    public void testGetPokemonComparatorName() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(pokemons, new ArrayList<Pokemon>());
    }

    @Test
    public void testGetPokemonComparatorIndex() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(pokemons, new ArrayList<Pokemon>());
    }

    @Test
    public void testGetPokemonComparatorCP() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(pokemons, new ArrayList<Pokemon>());
    }
}
