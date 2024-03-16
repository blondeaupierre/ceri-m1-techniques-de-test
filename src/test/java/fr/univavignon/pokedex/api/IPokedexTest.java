package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    //@Mock
    private static IPokedex pokedex;

    //@Mock
    private static Pokemon pokemon;
    private static Pokemon pokemon2;

    @BeforeAll
    public static void setUp() throws PokedexException {
        /*
        pokedex = mock(IPokedex.class);
        pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 2500, 2, 0.91);
        when(pokedex.size()).thenReturn(4);
        when(pokedex.getPokemon(1)).thenReturn(pokemon);
        when(pokedex.addPokemon(pokemon)).thenReturn(pokemon.getIndex());
        when(pokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
        when(pokedex.getPokemons(null)).thenReturn(new ArrayList<Pokemon>());
        when(pokedex.getPokemon(-10)).thenThrow(new PokedexException("Invalid index"));
        */
        pokedex = new Pokedex();
        pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 2500, 2, 0.91);
        pokemon2 = new Pokemon(2, "Pickachu", 127, 127, 91, 614, 65, 2501, 3, 0.92);

        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon2);
    }

    @Test
    public void testSize() {
        assertEquals(pokedex.size(),2);
    }

    @Test
    public void testAddPokedex() {
        assertEquals(pokedex.addPokemon(pokemon), pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokedex.getPokemon(0), pokemon);
        assertEquals(pokedex.getPokemon(0).getIndex(), 1);
        assertEquals(pokedex.getPokemon(0).getName(), "Bulbizarre");
        assertEquals(pokedex.getPokemon(0).getAttack(), 126);
        assertEquals(pokedex.getPokemon(0).getDefense(), 126);
        assertEquals(pokedex.getPokemon(0).getStamina(), 90);
        assertEquals(pokedex.getPokemon(0).getCp(), 613);
        assertEquals(pokedex.getPokemon(0).getHp(), 64);
        assertEquals(pokedex.getPokemon(0).getDust(), 2500);
        assertEquals(pokedex.getPokemon(0).getCandy(), 2);
        assertEquals(pokedex.getPokemon(0).getIv(), 0.91);
    }

    @Test
    public void testThrowsGetPokemon() throws PokedexException {
        try {
            pokedex.getPokemon(-10);
        } catch (PokedexException e) {
            assertEquals(e.getMessage(), "Invalid index");
        }
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        Assertions.assertTrue(pokemons.contains(pokemon));
    }

    @Test
    public void testGetPokemonComparatorName() {
        List<Pokemon> pokemonsSorted = pokedex.getPokemons(PokemonComparators.NAME);
        Assertions.assertTrue(pokemonsSorted.indexOf(pokemon) < pokemonsSorted.indexOf(pokemon2));
    }

    @Test
    public void testGetPokemonComparatorIndex() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.INDEX);
        Assertions.assertTrue(pokemons.indexOf(pokemon) < pokemons.indexOf(pokemon2));
    }

    @Test
    public void testGetPokemonComparatorCP() {
        List<Pokemon> pokemons = pokedex.getPokemons(PokemonComparators.CP);
        Assertions.assertTrue(pokemons.indexOf(pokemon) < pokemons.indexOf(pokemon2));
    }
}
