# API Gateway - Products Market

Servicio de enrutamiento centralizado para la plataforma de e-commerce Products Market.

## 📋 Descripción

Funciona como el núcleo de comunicaciones del ecosistema, proporcionando:
- Distribución inteligente de tráfico
- Equilibrio de cargas dinámico
- Localización automática de servicios
- Monitorización unificada
- Registro de actividad centralizado
- Verificaciones de estado

## 🔧 Tecnologías Utilizadas

- Java 21
- Spring Boot 3.4.5
- Lombok
- Spring Cloud Gateway
- Spring Cloud LoadBalancer
- Spring Cloud Netflix Eureka


## 🎯 Funcionalidades Clave

- Redirección transparente hacia microservicios
- Distribución automática de peticiones
- Localización dinámica de instancias (Eureka)
- Monitoreo de estado de servicios
- Recopilación de métricas de rendimiento
- Trazabilidad de requests y respuestas
- Dashboard de servicios activos

## 🚦 Configuración de Rutas

| Módulo | Operaciones | Patrón de URL | Servicio Backend | Función |
|--------|-------------|---------------|------------------|---------|
| Usuarios | GET/POST/PUT/DELETE | `/api/users/**` | `user-service:8081` | Administración de cuentas |
| Productos | GET/POST/PUT | `/api/products/**` | `product-service:8082` | Inventario y catálogo |
| Pedidos | GET/POST/PUT/DELETE | `/api/orders/**` | `order-service:8083` | Procesamiento de compras |
| Estado | GET | `/health` | `user-service:8081/actuator/health` | Diagnóstico del sistema |

## 🔨 Parámetros de Configuración

```properties
server.port=8087
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
```

## ▶️ Proceso de Arranque

1. **Levantar Eureka Server** (puerto 8761)

2. **Arrancar microservicios principales:**
    - User Service (8081)
    - Product Service (8082)
    - Order Service (8083)

3. **Inicializar Gateway:**

4. **Verificar funcionamiento:** [http://localhost:8087](http://localhost:8087)

## 🔗 Rutas de Acceso

### Gestión de Usuarios
```http
GET http://localhost:8087/api/users
GET http://localhost:8087/api/users/1
POST http://localhost:8087/api/users
PUT http://localhost:8087/api/users/1
```

### Catálogo de Productos
```http
GET http://localhost:8087/api/products
GET http://localhost:8087/api/products/1
GET http://localhost:8087/api/products/available
POST http://localhost:8087/api/products
```

### Procesamiento de Pedidos
```http
GET http://localhost:8087/api/orders
POST http://localhost:8087/api/orders
GET http://localhost:8087/api/orders/user/1
PUT http://localhost:8087/api/orders/1/status
```

### Diagnósticos
```http
GET http://localhost:8087/health
```

## 💡 Ventajas Arquitectónicas

| Aspecto | Durante Desarrollo | En Producción |
|---------|-------------------|---------------|
| Acceso unificado | URLs consistentes | Escalado horizontal |
| Distribución automática | Logs centralizados | Recuperación ante fallos |
| Descubrimiento dinámico | Depuración simplificada | Métricas consolidadas |
| Control de errores | Configuración centralizada | Seguridad unificada |

## 🚀 Mejoras Planificadas de futuro

- 🛡️ Sistema de autenticación JWT
- ⏱️ Limitación de velocidad de requests
- 🔄 Patrones de recuperación ante fallos

---

## 👨‍ Autor

### **Jose Manuel Siguero Pérez**
### [Linkedin](https://www.linkedin.com/in/jose-manuel-siguero)