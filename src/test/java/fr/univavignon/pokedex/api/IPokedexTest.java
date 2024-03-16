package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private static IPokedex pokedex;
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
        Pokemon pokemonToAdd = new Pokemon(3, "Salamèche", 128, 128, 92, 615, 66, 2502, 4, 0.93);
        assertEquals(pokedex.addPokemon(pokemonToAdd), pokemonToAdd.getIndex());
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

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-10);
        });

        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(200);
        });
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

    @Test
    public void testCreatePokemon() throws PokedexException {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        PokemonMetadata pokemonMetadata = new PokemonMetadata(10, "Pikachu", 100, 100, 100);
        List<PokemonMetadata> Metadatas = new ArrayList<>();
        Metadatas.add(pokemonMetadata);

        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(Metadatas);
        IPokedex newPokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon = newPokedex.createPokemon(10, 10, 10, 10, 10);

        assertEquals(pokemon.getIndex(), 10);
        assertEquals(pokemon.getName(), "Pikachu");
        assertEquals(pokemon.getAttack(), 100);
        assertEquals(pokemon.getDefense(), 100);
        assertEquals(pokemon.getStamina(), 100);
        assertEquals(pokemon.getCp(), 10);
        assertEquals(pokemon.getHp(), 10);
        assertEquals(pokemon.getDust(), 10);
        assertEquals(pokemon.getCandy(), 10);
        assertEquals(pokemon.getIv(), 0);

        assertThrows(PokedexException.class, () -> {
            newPokedex.createPokemon(-10, 10, 10, 10, 10);
        });

        assertThrows(PokedexException.class, () -> {
            newPokedex.createPokemon(200, 10, 10, 10, 10);
        });
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata pokemonMetadata1 = new PokemonMetadata(10, "Pikachu", 100, 100, 100);
        PokemonMetadata pokemonMetadata2 = new PokemonMetadata(11, "Raichu", 101, 101, 101);
        List<PokemonMetadata> Metadatas = new ArrayList<>();
        Metadatas.add(pokemonMetadata1);
        Metadatas.add(pokemonMetadata2);
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(Metadatas);

        assertEquals(pokemonMetadataProvider.getPokemonMetadata(10), pokemonMetadata1);

        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(-10);
        });

        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(200);
        });
    }
}
