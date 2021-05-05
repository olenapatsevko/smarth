package tef.smarth.service.api;

import tef.smarth.api.spooncalcular.response.IngredientsRecipe;
import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.IngredientsForm;
import tef.smarth.model.Menu;

import java.util.List;

public interface SpoonService {

    MenuResponse getMenu(Menu menu);

    SpoonRecipeSummary getRecipe(int id);

    List<IngredientsRecipe> getListOfRecipes(IngredientsForm ingredientsForm);
}
