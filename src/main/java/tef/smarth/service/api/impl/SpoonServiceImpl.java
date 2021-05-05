package tef.smarth.service.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.api.spooncalcular.SpoonCalcularClient;
import tef.smarth.api.spooncalcular.request.IngredientsRequest;
import tef.smarth.api.spooncalcular.response.IngredientsRecipe;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.IngredientsForm;
import tef.smarth.model.Menu;
import tef.smarth.service.api.SpoonService;

import java.util.Arrays;
import java.util.List;

@Service
public class SpoonServiceImpl implements SpoonService {

    @Autowired
    SpoonCalcularClient spoonCalcularClient;

    @Override
    public MenuResponse getMenu(Menu menu) {
        return spoonCalcularClient.getMenu(menu);
    }

    @Override
    public SpoonRecipeSummary getRecipe(int id) {
        return spoonCalcularClient.getRecipe(id);
    }

    @Override
    public List<IngredientsRecipe> getListOfRecipes(IngredientsForm ingredientsForm) {
        return  spoonCalcularClient.getRecipesByIngredients(IngredientsRequest.builder().number(ingredientsForm.getNumber())
                .ingredients(Arrays.asList(ingredientsForm.getIngredients().split(",")))
                .build());
    }
}
