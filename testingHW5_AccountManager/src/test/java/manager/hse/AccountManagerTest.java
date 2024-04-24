package manager.hse;

// import org.junit.Assert.*;
// import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountManagerTest {

//    // Создаем заглушки для IServer и IPasswordEncoder
//    @Mock
//    private IServer serverMock;
//    @Mock
//    private IPasswordEncoder passwordEncoderMock;
//
//    private AccountManager accountManager;
//
//    @BeforeEach
//    public void setUp() {
//        // Инициализируем объект AccountManager перед каждым тестом
//        serverMock = mock(IServer.class);
//        passwordEncoderMock = mock(IPasswordEncoder.class);
//        accountManager = new AccountManager();
//        accountManager.init(serverMock, passwordEncoderMock);
//    }
//
//    // Тест для метода callLogin при успешной авторизации
//    @Test
//    public void testCallLogin_SuccessfulLogin() {
//        // Задаем поведение заглушки IServer при вызове метода login
//        when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.SUCCESS, 12345L));
//        AccountManagerResponse response = accountManager.callLogin("testUser", "password123");
//        assertEquals(AccountManagerResponse.SUCCEED, response.code);
//        assertEquals(12345L, response.response);
//    }
//
//    // Другие тесты для метода callLogin
//
//    // Тест для метода callLogout при успешном выходе
//    @Test
//    public void testCallLogout_SuccessfulLogout() {
//        // Задаем поведение заглушки IServer при вызове метода logout
//        when(serverMock.logout(anyLong())).thenReturn(new ServerResponse(ServerResponse.SUCCESS, null));
//        // Вызываем тестируемый метод
//        AccountManagerResponse response = accountManager.callLogout("testUser", 12345L);
//        // Проверяем ожидаемый результат
//        assertEquals(AccountManagerResponse.SUCCEED, response.code);
//    }
//
//    // Другие тесты для метода callLogout
//
//    // Тесты для других методов класса AccountManager

}

