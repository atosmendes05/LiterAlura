package br.com.livraria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> calssse) {
        try{
            return  mapper.readValue(json,calssse);
        }catch (JsonProcessingException e){
            System.out.println("Erro na conversão do dados");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> List<T> obterlista(String json, Class<T> classe) {
        try{
            CollectionType lista = mapper.getTypeFactory()
                    .constructCollectionType(List.class,classe);

            return mapper.readValue(json,lista);

        }catch (JsonProcessingException e){
            System.out.println("Erro na conversão de dados");
            e.printStackTrace();
            return null;
        }
    }
}
