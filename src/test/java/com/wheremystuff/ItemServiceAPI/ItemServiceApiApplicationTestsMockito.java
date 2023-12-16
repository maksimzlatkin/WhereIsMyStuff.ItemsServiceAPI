//package com.wheremystuff.ItemServiceAPI;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//import com.wheremystuff.ItemServiceAPI.controllers.ItemController;
//import com.wheremystuff.ItemServiceAPI.services.ItemService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class ItemServiceApiApplicationTestsMockito {
//
//    @Mock
//    private ItemService itemService;
//
//    @InjectMocks
//    private ItemController itemController;
//
//    @BeforeEach
//    void setMockOutput() {
//        when(itemService.getItems()).thenReturn("Item Test");
//    }
//
//    @Test
//    public static void shouldReturnItem() {
//
//    }
//}
