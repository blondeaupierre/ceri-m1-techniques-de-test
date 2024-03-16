package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    List<PokemonMetadata> pokemonMetadatas;

    public PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadatas) {
        this.pokemonMetadatas = pokemonMetadatas;
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= 151) {
            throw new PokedexException("Invalid index");
        }
        for (PokemonMetadata pokemonMetadata : pokemonMetadatas) {
            if (pokemonMetadata.getIndex() == index) {
                return pokemonMetadata;
            }
        }
        throw new PokedexException("PokemonMetadata not found for index " + index);
    }
}
