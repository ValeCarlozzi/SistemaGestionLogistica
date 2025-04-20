# Sistema de Gestión Logística

Este proyecto es un sistema de escritorio desarrollado en Java para administrar la logística de una empresa de retail que distribuye electrodomésticos y artículos para el hogar a través de una red de sucursales y centros logísticos.

## Tecnologías utilizadas

- **Lenguaje:** Java
- **Interfaz gráfica:** Swing
- **Base de datos:** PostgreSQL
- **Arquitectura:** Separación en capas (UI, Lógica, Base de Datos)

## Objetivo del sistema

El sistema permite gestionar:
- Sucursales (registro, estado, horarios, etc.)
- Rutas logísticas entre sucursales (tiempo, capacidad, estado)
- Productos disponibles para la venta
- Stock de productos por sucursal
- Órdenes de provisión y asignación de caminos logísticos
- Funciones como cálculo de **flujo máximo** y **PageRank** de las sucursales

## ✨ Funcionalidades principales

1. **Gestión de sucursales**
   - Alta, baja, modificación, búsqueda y visualización
   - Estado operativo / no operativo

2. **Gestión de caminos**
   - Registro de rutas entre sucursales o centros logísticos
   - Incluye tiempo, capacidad y estado operativo

3. **Gestión de productos**
   - Registro de nombre, descripción, precio y peso

4. **Stock por sucursal**
   - Cantidad de productos en cada sucursal

5. **Órdenes de provisión**
   - Selección de productos y cantidades para una sucursal
   - Asignación de rutas considerando restricciones de tiempo y stock

6. **Inactivación de sucursales o rutas**
   - Para mantenimiento, feriados, etc.

7. **Análisis logístico**
   - Cálculo de flujo máximo desde el puerto al centro
   - PageRank de las sucursales