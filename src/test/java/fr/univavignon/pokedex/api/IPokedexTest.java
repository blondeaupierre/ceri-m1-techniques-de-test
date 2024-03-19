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

    @Mock
    private static Pokemon pokemon;

    @Mock
    private static Pokemon pokemon2;

    @Mock
    private static Pokemon pokemonToAdd;

    @Mock
    static IPokemonFactory pokemonFactory;

    @Mock
    static PokemonMetadata pokemonMetadata;

    @Mock
    static PokemonMetadata pokemonMetadata2;

    @Mock
    static IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeAll
    public static void setUp() throws PokedexException {
        /*
        pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 2500, 2, 0.91);
        when(pokedex.size()).thenReturn(4);
        when(pokedex.getPokemon(1)).thenReturn(pokemon);
        when(pokedex.addPokemon(pokemon)).thenReturn(pokemon.getIndex());
        when(pokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
        when(pokedex.getPokemons(null)).thenReturn(new ArrayList<Pokemon>());
        when(pokedex.getPokemon(-10)).thenThrow(new PokedexException("Invalid index"));
        */
        pokedex = new Pokedex();

        pokemon = mock(Pokemon.class);
        pokemon2 = mock(Pokemon.class);

        when(pokemon.getIndex()).thenReturn(1);
        when(pokemon.getName()).thenReturn("Bulbizarre");
        when(pokemon.getAttack()).thenReturn(126);
        when(pokemon.getDefense()).thenReturn(126);
        when(pokemon.getStamina()).thenReturn(90);
        when(pokemon.getCp()).thenReturn(613);
        when(pokemon.getHp()).thenReturn(64);
        when(pokemon.getDust()).thenReturn(2500);
        when(pokemon.getCandy()).thenReturn(2);
        when(pokemon.getIv()).thenReturn(0.91);

        when(pokemon2.getIndex()).thenReturn(2);
        when(pokemon2.getName()).thenReturn("Pickachu");
        when(pokemon2.getAttack()).thenReturn(127);
        when(pokemon2.getDefense()).thenReturn(127);
        when(pokemon2.getStamina()).thenReturn(91);
        when(pokemon2.getCp()).thenReturn(614);
        when(pokemon2.getHp()).thenReturn(65);
        when(pokemon2.getDust()).thenReturn(2501);
        when(pokemon2.getCandy()).thenReturn(3);
        when(pokemon2.getIv()).thenReturn(0.92);

        pokemonToAdd = mock(Pokemon.class);
        when(pokemonToAdd.getIndex()).thenReturn(3);
        when(pokemonToAdd.getName()).thenReturn("Salameche");
        when(pokemonToAdd.getAttack()).thenReturn(100);
        when(pokemonToAdd.getDefense()).thenReturn(100);
        when(pokemonToAdd.getStamina()).thenReturn(100);
        when(pokemonToAdd.getCp()).thenReturn(10);
        when(pokemonToAdd.getHp()).thenReturn(10);
        when(pokemonToAdd.getDust()).thenReturn(10);
        when(pokemonToAdd.getCandy()).thenReturn(10);
        when(pokemonToAdd.getIv()).thenReturn(0.0);

        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon2);

        pokemonMetadata = mock(PokemonMetadata.class);
        when(pokemonMetadata.getIndex()).thenReturn(3);
        when(pokemonMetadata.getName()).thenReturn("Salameche");
        when(pokemonMetadata.getAttack()).thenReturn(100);
        when(pokemonMetadata.getDefense()).thenReturn(100);
        when(pokemonMetadata.getStamina()).thenReturn(100);

        pokemonMetadata2 = mock(PokemonMetadata.class);
        when(pokemonMetadata2.getIndex()).thenReturn(4);
        when(pokemonMetadata2.getName()).thenReturn("Raichu");
        when(pokemonMetadata2.getAttack()).thenReturn(101);
        when(pokemonMetadata2.getDefense()).thenReturn(101);
        when(pokemonMetadata2.getStamina()).thenReturn(101);

        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(3)).thenReturn(pokemonMetadata);
        when(pokemonMetadataProvider.getPokemonMetadata(4)).thenReturn(pokemonMetadata2);
        when(pokemonMetadataProvider.getPokemonMetadata(-10)).thenThrow(new PokedexException("Invalid index"));
        when(pokemonMetadataProvider.getPokemonMetadata(200)).thenThrow(new PokedexException("Invalid index"));
        when(pokemonMetadataProvider.getPokemonMetadata(12)).thenThrow(new PokedexException("PokemonMetadata not found for index " + 12));

        pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(3, 10, 10, 10, 10)).thenReturn(pokemonToAdd);
        when(pokemonFactory.createPokemon(-10, 10, 10, 10, 10)).thenThrow(new PokedexException("Invalid index"));
        when(pokemonFactory.createPokemon(200, 10, 10, 10, 10)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokedex() {
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
        Assertions.assertTrue(pokemons.contains(pokemon2));
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
        IPokedex newPokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon = newPokedex.createPokemon(3, 10, 10, 10, 10);

        assertEquals(pokemon.getIndex(), 3);
        assertEquals(pokemon.getName(), "Salameche");
        assertEquals(pokemon.getAttack(), 100);
        assertEquals(pokemon.getDefense(), 100);
        assertEquals(pokemon.getStamina(), 100);
        assertEquals(pokemon.getCp(), 10);
        assertEquals(pokemon.getHp(), 10);
        assertEquals(pokemon.getDust(), 10);
        assertEquals(pokemon.getCandy(), 10);
        assertEquals(pokemon.getIv(), 0.0);

        assertThrows(PokedexException.class, () -> {
            newPokedex.createPokemon(-10, 10, 10, 10, 10);
        });

        assertThrows(PokedexException.class, () -> {
            newPokedex.createPokemon(200, 10, 10, 10, 10);
        });
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        List<PokemonMetadata> metadatas = new ArrayList<>();
        metadatas.add(pokemonMetadata);
        metadatas.add(pokemonMetadata2);

        IPokedex newPokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        assertEquals(newPokedex.getPokemonMetadata(10), pokemonMetadataProvider.getPokemonMetadata(10));

        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(-10);
        });

        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(200);
        });

        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(12);
        });
    }
}
