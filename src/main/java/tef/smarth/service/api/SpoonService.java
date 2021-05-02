package tef.smarth.service.api;

import tef.smarth.api.spooncalcular.response.MenuResponse;
import tef.smarth.api.spooncalcular.response.SpoonRecipeSummary;
import tef.smarth.model.Menu;

public interface SpoonService {

    MenuResponse getMenu(Menu menu);

    SpoonRecipeSummary getRecipe(int id);
}
