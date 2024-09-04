package com.PetStore.APItesting.tests.guide;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.PetStore.APItesting.model.Category;
import com.PetStore.APItesting.model.Pet;
import com.PetStore.APItesting.model.Tags;
import com.PetStore.APItesting.utilities.commons.TestGroups;
import com.PetStore.APItesting.base.testsetup.AbstractBaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GuideTest extends AbstractBaseTest {

        private static final String SEPARATOR_PATH = "/";

        @Parameters({ "BaseURL", "API_version" })
        public GuideTest(String BaseURL, String apiVersion) {
                super(BaseURL, apiVersion);
        }

        @Test(groups = { TestGroups.SMOKE, TestGroups.GUIDE })
        @Severity(SeverityLevel.CRITICAL)
        @Description("add a pet - happy path")
        @Parameters({ "id", "name", "status" })
        public void postAddPet(Integer id, String name, String status, ITestContext context) {

                Gson gson = new Gson();

                Category category = new Category();
                category.setId(1);
                category.setName("Perla");

                ArrayList<String> photoUrls= new ArrayList<String>();
                photoUrls.add("photo");

                ArrayList<Tags> tags= new ArrayList<Tags>();
                Tags tagsObject = new Tags();
                tagsObject.setId(1);
                tagsObject.setName("Perla");
                tagsObject.setId(0);
                tagsObject.setName("Kenai");
                tags.add(tagsObject);


                Pet pet = new Pet();
                pet.setId(id);
                pet.setName(name);
                pet.setCategory(category);
                pet.setPhotoUrls(photoUrls);
                pet.setTags(tags);
                pet.setStatus(status);


                String bodyRequest = gson.toJson(pet);
                JsonObject bodyPayload = JsonParser.parseString(bodyRequest).getAsJsonObject();
                Response response = given().spec(request)
                                .header("Content-type", "application/json; charset=UTF-8")
                                .body(bodyPayload.toString())
                                .post("");

                response.then().assertThat()
                                .statusCode(HttpStatus.SC_OK)
                                .body(matchesJsonSchemaInClasspath("schemas/guide/Pet-post-200-Ok-schema.json"));

        }

        @Test(groups = { TestGroups.SMOKE, TestGroups.GUIDE })
        @Severity(SeverityLevel.CRITICAL)
        @Description("add a pet - happy path")
        @Parameters({ "id", "name", "status" })
        public void puttAddPet(Integer id, String name, String status, ITestContext context) {

                Gson gson = new Gson();

                Category category = new Category();
                category.setId(context.hashCode());
                category.setName("Juana");

                ArrayList<String> photoUrls= new ArrayList<String>();
                photoUrls.add("photo");

                ArrayList<Tags> tags= new ArrayList<Tags>();
                Tags tagsObject = new Tags();
                tagsObject.setId(1);
                tagsObject.setName("Perla");
                tagsObject.setId(0);
                tagsObject.setName("Kenai");
                tags.add(tagsObject);


                Pet pet = new Pet();
                pet.setId(id);
                pet.setName(name);
                pet.setCategory(category);
                pet.setPhotoUrls(photoUrls);
                pet.setTags(tags);
                pet.setStatus(status);


                String bodyRequest = gson.toJson(pet);
                JsonObject bodyPayload = JsonParser.parseString(bodyRequest).getAsJsonObject();
                Response response = given().spec(request)
                        .header("Content-type", "application/json; charset=UTF-8")
                        .body(bodyPayload.toString())
                        .put("");

                response.then().assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .body(matchesJsonSchemaInClasspath("schemas/guide/Pet-post-200-Ok-schema.json"));
        }

        @Test(groups = { TestGroups.SMOKE, TestGroups.GUIDE })
        @Severity(SeverityLevel.CRITICAL)
        @Description("add a pet - happy path")
        @Parameters({ "id", "name", "idCategory","nameCategory","photoUrls","idTags1", "nameTagss1","idTags2","nameTagss2","status" })
        public void postAddPet1(Integer id, String name, Integer idCategory, String nameCategory, String photoUrls, Integer idTags1, String nameTagss1, Integer idTags2, String nameTagss2, String status, ITestContext context) {
                Gson gson = new Gson();

                Pet pet = new Pet();
                pet.setId(id);
                pet.setName(name);
                Category category=new Category(idCategory,nameCategory);
                //category.setId(idCategory);
                //category.setName(nameCategory);
                ArrayList<String> listUrl= new ArrayList<String>();
                listUrl.add(photoUrls);
                pet.setCategory(category);
                pet.setPhotoUrls(listUrl);
                ArrayList<Tags> listTags= new ArrayList<Tags>();
                Tags tag = new Tags(idTags1, nameTagss1);
                //tag.setId(idTags1);
                //tag.setName(nameTagss1);
                listTags.add(tag);
                tag = new Tags(idTags2,nameTagss2);
                //tag.setId(idTags2);
                //tag.setName(nameTagss2);
                listTags.add(tag);
                pet.setTags(listTags);
                pet.setStatus(status);

                //console.log("Id: "+id);
                String bodyRequest = gson.toJson(pet);
                JsonObject bodyPayload = JsonParser.parseString(bodyRequest).getAsJsonObject();
                Response response = given().spec(request)
                        .header("Content-type", "application/json; charset=UTF-8")
                        .body(bodyPayload.toString())
                        .post("");

                response.then().assertThat()
                        .statusCode(HttpStatus.SC_OK)
                        .body(matchesJsonSchemaInClasspath("schemas/guide/Pet-post-200-Ok-schema.json"));
        }


        @Test(groups = { TestGroups.SMOKE, TestGroups.GUIDE })
        @Severity(SeverityLevel.CRITICAL)
        @Description("add a pet - happy path")
        @Parameters({ "id", "name", "status" })
        public void postAddPetBadRequest(Integer id, String name, String status, ITestContext context) {

                Gson gson = new Gson();

                Category category = new Category();
                category.setId(1);
                category.setName("Perla");

                ArrayList<String> photoUrls= new ArrayList<String>();
                photoUrls.add("photo");

                ArrayList<Tags> tags= new ArrayList<Tags>();
                Tags tagsObject = new Tags();
                tagsObject.setId(1);
                tagsObject.setName("Perla");
                //tagsObject.setId(0);
                tagsObject.setName("Kenai");
                tags.add(tagsObject);


                Pet pet = new Pet();
                pet.setName(name);
                pet.setCategory(category);
                pet.setTags(tags);
                pet.setStatus(status);

                String bodyRequest = gson.toJson(pet);
                JsonObject bodyPayload = JsonParser.parseString(bodyRequest).getAsJsonObject();
                Response response = given().spec(request)
                        .header("Content-type", "application/json; charset=UTF-8")
                        .body(bodyPayload.toString())
                        .post("");

                response.then().assertThat()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .body(matchesJsonSchemaInClasspath("schemas/guide/Pet-post-500-BadRequest-schema.json"));
        }


        @Test(groups = { TestGroups.SMOKE, TestGroups.GUIDE })
        @Severity(SeverityLevel.CRITICAL)
        @Description("add a pet - happy path")
        @Parameters({ "id", "name", "status" })
        public void postAddPetInternalServer(Integer id, String name, String status, ITestContext context) {
                Gson gson = new Gson();

                Category category = new Category();
                category.setId(1);
                category.setName("Perla");

                ArrayList<String> photoUrls= new ArrayList<String>();
                photoUrls.add("photo");

                ArrayList<Tags> tags= new ArrayList<Tags>();
                Tags tagsObject = new Tags();
                tagsObject.setId(1);
                tagsObject.setName("Perla");
                tagsObject.setId(0);
                tagsObject.setName("Kenai");

                Pet pet = new Pet();
                pet.setName(name);
                pet.setCategory(category);

                String bodyRequest = gson.toJson(pet);
                JsonObject bodyPayload = JsonParser.parseString(bodyRequest).getAsJsonObject();
                Response response = given().spec(request)
                        .header("Content-type", "application/json; charset=UTF-8")
                        .body(bodyPayload.toString())
                        .post("");

                response.then().assertThat()
                        .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)

                        .body(matchesJsonSchemaInClasspath("schemas/guide/Pet-post-500-BadRequest-schema.json"));
        }


}
