package tef.smarth.mapper;

public interface Mapping<M,E>{

    E convertToEntity (M model);

    M convertToModel(E entity);
}
