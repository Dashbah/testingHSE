package manager.hse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CallLoginTest {

    @Mock
    private IServer serverMock;

    @Mock
    private IPasswordEncoder passwordEncoderMock;

    private AccountManager accountManager;

    @BeforeEach
    public void setUp() {
        serverMock = mock(IServer.class);
        passwordEncoderMock = mock(IPasswordEncoder.class);
        accountManager = new AccountManager();
        when(passwordEncoderMock.makeSecure(anyString())).thenReturn("password");
        // accountManager.active
        accountManager.init(serverMock, passwordEncoderMock);
    }

    // Тест успешной авторизации
    @Test
    public void testCallLogin_SuccessfulLogin1() {
        // Задаем поведение заглушки IServer при вызове метода login
        // when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.SUCCESS, 12345L));
        // Задаем поведение заглушки IPasswordEncoder при вызове метода makeSecure
        // when(passwordEncoderMock.makeSecure(anyString())).thenReturn("mockedPassword");

        AccountManagerResponse response = accountManager.callLogin("testUser", "password");

        assertEquals(AccountManagerResponse.SUCCEED, response.code);
        assertEquals(12345L, response.response);
    }

    // Тест успешной авторизации
    @Test
    public void testCallLogin_SuccessfulLogin() {
        when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.SUCCESS, 12345L));
        AccountManagerResponse response = accountManager.callLogin("testUser", "password123");
        assertEquals(AccountManagerResponse.SUCCEED, response.code);
        assertEquals(12345L, response.response);
    }

    // Тест повторной попытки авторизации с тем же логином
    @Test
    public void testCallLogin_AlreadyLogged() {
        when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.ALREADY_LOGGED, null));
        AccountManagerResponse response = accountManager.callLogin("testUser", "password123");
        assertEquals(AccountManagerResponse.ALREADY_LOGGED, response.code);
    }

    // Тест авторизации с некорректным паролем
    @Test
    public void testCallLogin_IncorrectPassword() {
        when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.NO_USER_INCORRECT_PASSWORD, null));
        AccountManagerResponse response = accountManager.callLogin("testUser", "incorrectPassword");
        assertEquals(AccountManagerResponse.NO_USER_INCORRECT_PASSWORD, response.code);
    }

    // Тест обработки некорректного ответа от сервера
    @Test
    public void testCallLogin_IncorrectServerResponse() {
        when(serverMock.login(anyString(), anyString())).thenReturn(new ServerResponse(ServerResponse.UNDEFINED_ERROR, null));
        AccountManagerResponse response = accountManager.callLogin("testUser", "password123");
        assertEquals(AccountManagerResponse.INCORRECT_RESPONSE, response.code);
    }
}
