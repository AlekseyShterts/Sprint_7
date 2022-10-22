import ScoooterCouriers.Couriers;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;

public class CourierCreateTest {

    Couriers courier = new Couriers();

    //В этом тесте проверяется что создается курьер и проверяется ответ
    @Test
    @Description("Метод создает нового курьера")
    public void courierCreate() {
        courier.courierNewBodyDataGenerate();
        Assert.assertEquals(201, courier.getResponseStatusCode());
    }

    @Test
    @Description("Метод создает дубль курьера")
    public void courierCreateNotNew() {
        courier.courierNewBodyDataGenerateNotNew();
        Assert.assertEquals(409, courier.getResponseStatusCode());
    }

    @Test
    @Description("Метод создает курьера без логина в запросе")
    public void courierCreateNoLogin() {
        courier.courierNewBodyDataGenerateNotLogin();
        Assert.assertEquals(400, courier.getResponseStatusCode());
    }

    @Test
    @Description("Метод создает курьера без пароля в запросе")
    public void courierCreateNoPassword() {
        courier.courierNewBodyDataGenerateNotPass();
        Assert.assertEquals(400, courier.getResponseStatusCode());
    }
    //в документации нет запрета на создание курьера без имени, в postman возвращвет 201
    @Test
    @Description("Метод создает курьера без имени в запросе")
    public void courierCreateNoName() {
        courier.courierNewBodyDataGenerateNotName();
        Assert.assertEquals(201, courier.getResponseStatusCode());
    }

    @Test
    @Description("Метод создает дубль курьера - проверка текста ошибки")
    public void courierCreateNotNewLogin() {
        courier.courierNewBodyDataGenerateNotNew();
        Assert.assertEquals("Этот логин уже используется. Попробуйте другой.", courier.getMessageResponseOfCreateCourier());
    }
}
