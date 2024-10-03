-- Insertar datos en la tabla Ciudad
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (1, 'Bogotá', 11001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (2, 'Medellín', 05001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (3, 'Cali', 76001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (4, 'Cartagena', 13001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (5, 'Barranquilla', 08001);

-- Insertar datos en la tabla Sucursal
INSERT INTO Sucursal (id_sucursal, nombre, tamanio, direccion, telefono, id_ciudad) VALUES (1, 'Sucursal Centro', 150.00, 'Calle 1 # 2-3', '1234567', 1);
INSERT INTO Sucursal (id_sucursal, nombre, tamanio, direccion, telefono, id_ciudad) VALUES (2, 'Sucursal Norte', 200.00, 'Avenida 2 # 4-5', '2345678', 1);
INSERT INTO Sucursal (id_sucursal, nombre, tamanio, direccion, telefono, id_ciudad) VALUES (3, 'Sucursal El Poblado', 120.50, 'Carrera 3 # 6-7', '3456789', 2);
INSERT INTO Sucursal (id_sucursal, nombre, tamanio, direccion, telefono, id_ciudad) VALUES (4, 'Sucursal La Candelaria', 130.75, 'Calle 8 # 10-11', '4567890', 2);
INSERT INTO Sucursal (id_sucursal, nombre, tamanio, direccion, telefono, id_ciudad) VALUES (5, 'Sucursal La Playa', 160.00, 'Calle 5 # 2-3', '5678901', 3);

-- Insertar datos en la tabla InfoExtraBodega
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (1, 100.50, 30, 100, 500.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (2, 120.75, 35, 150, 600.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (3, 110.25, 28, 200, 550.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (4, 115.00, 40, 75, 300.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (5, 130.00, 50, 80, 450.00);

-- Insertar datos en la tabla EspecificacionEmpacado
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (1, 1.25, 0.5);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (2, 0.75, 0.3);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (3, 1.50, 0.8);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (4, 2.00, 1.0);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (5, 0.50, 0.2);

-- Insertar datos en la tabla Producto
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (1, '1234567890123', 'Producto A', 10.50, 'Caja', 12, 'Unidades', TO_DATE('2025-12-31', 'YYYY-MM-DD'), 1);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (2, '1234567890124', 'Producto B', 15.75, 'Paquete', 6, 'Unidades', TO_DATE('2024-05-15', 'YYYY-MM-DD'), 2);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (3, '1234567890125', 'Producto C', 8.30, 'Botella', 24, 'Mililitros', TO_DATE('2024-11-20', 'YYYY-MM-DD'), 3);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (4, '1234567890126', 'Producto D', 20.00, 'Lata', 12, 'Unidades', TO_DATE('2023-08-30', 'YYYY-MM-DD'), 4);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (5, '1234567890127', 'Producto E', 5.99, 'Bolsa', 10, 'Gramos', TO_DATE('2025-01-01', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla Bodega
INSERT INTO Bodega (id_bodega, nombre, tamanio, id_sucursal, id_infoExtraBodega) VALUES (1, 'Bodega Principal', 300.00, 1, 1);
INSERT INTO Bodega (id_bodega, nombre, tamanio, id_sucursal, id_infoExtraBodega) VALUES (2, 'Bodega Secundaria', 150.00, 2, 2);
INSERT INTO Bodega (id_bodega, nombre, tamanio, id_sucursal, id_infoExtraBodega) VALUES (3, 'Bodega Norte', 250.00, 3, 3);
INSERT INTO Bodega (id_bodega, nombre, tamanio, id_sucursal, id_infoExtraBodega) VALUES (4, 'Bodega Sur', 200.00, 4, 4);
INSERT INTO Bodega (id_bodega, nombre, tamanio, id_sucursal, id_infoExtraBodega) VALUES (5, 'Bodega Este', 180.00, 5, 5);

-- Insertar datos en la tabla DetalleCostoBodega
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_bodega) VALUES (1, 5.00, 100, 1);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_bodega) VALUES (2, 4.75, 150, 2);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_bodega) VALUES (3, 6.25, 200, 3);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_bodega) VALUES (4, 3.50, 120, 4);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_bodega) VALUES (5, 7.00, 80, 5);

-- Insertar datos en la tabla ProductoPerecedero
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento) VALUES (1, TO_DATE('2025-01-15', 'YYYY-MM-DD'));
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento) VALUES (2, TO_DATE('2024-12-05', 'YYYY-MM-DD'));
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento) VALUES (3, TO_DATE('2023-11-10', 'YYYY-MM-DD'));
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento) VALUES (4, TO_DATE('2025-03-20', 'YYYY-MM-DD'));
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento) VALUES (5, TO_DATE('2024-09-30', 'YYYY-MM-DD'));

-- Insertar datos en la tabla InfoExtraOrden
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (1, 50, 8.50);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (2, 30, 15.00);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (3, 20, 12.75);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (4, 60, 9.99);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (5, 25, 14.00);

-- Insertar datos en la tabla OrdenCompra
INSERT INTO OrdenCompra (id_ordenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (1, TO_DATE('2024-09-01', 'YYYY-MM-DD'), 'Pendiente', TO_DATE('2024-09-15', 'YYYY-MM-DD'), 1);
INSERT INTO OrdenCompra (id_ordenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (2, TO_DATE('2024-09-02', 'YYYY-MM-DD'), 'Completada', TO_DATE('2024-09-20', 'YYYY-MM-DD'), 2);
INSERT INTO OrdenCompra (id_ordenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (3, TO_DATE('2024-09-03', 'YYYY-MM-DD'), 'En Proceso', NULL, 3);
INSERT INTO OrdenCompra (id_ordenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (4, TO_DATE('2024-09-04', 'YYYY-MM-DD'), 'Cancelada', NULL, 4);
INSERT INTO OrdenCompra (id_ordenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (5, TO_DATE('2024-09-05', 'YYYY-MM-DD'), 'Pendiente', TO_DATE('2024-09-25', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla RecepcionProducto
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_ordenCompra, id_bodega) VALUES (1, TO_DATE('2024-09-10', 'YYYY-MM-DD'), 1, 1);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_ordenCompra, id_bodega) VALUES (2, TO_DATE('2024-09-15', 'YYYY-MM-DD'), 2, 2);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_ordenCompra, id_bodega) VALUES (3, TO_DATE('2024-09-20', 'YYYY-MM-DD'), 3, 3);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_ordenCompra, id_bodega) VALUES (4, TO_DATE('2024-09-25', 'YYYY-MM-DD'), 4, 4);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_ordenCompra, id_bodega) VALUES (5, TO_DATE('2024-09-30', 'YYYY-MM-DD'), 5, 5);

-- Insertar datos en la tabla InfoExtraProveedor
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (1, 500);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (2, 300);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (3, 800);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (4, 650);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (5, 400);

-- Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-7', 'Proveedor A', 'Calle 1 # 2-34', 'Juan Pérez', '3001234567', 1);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-8', 'Proveedor B', 'Carrera 5 # 7-89', 'María López', '3101234567', 2);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-9', 'Proveedor C', 'Avenida 3 # 10-23', 'Carlos Gómez', '3201234567', 3);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-0', 'Proveedor D', 'Calle 12 # 15-67', 'Ana Torres', '3301234567', 4);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-1', 'Proveedor E', 'Carrera 9 # 18-34', 'Luis Martínez', '3401234567', 5);

-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (id_cliente, cedula, nombre) VALUES (1, '12345678', 'Sofía Rojas');
INSERT INTO Cliente (id_cliente, cedula, nombre) VALUES (2, '23456789', 'Andrés Castillo');
INSERT INTO Cliente (id_cliente, cedula, nombre) VALUES (3, '34567890', 'Valentina Ruiz');
INSERT INTO Cliente (id_cliente, cedula, nombre) VALUES (4, '45678901', 'Javier González');
INSERT INTO Cliente (id_cliente, cedula, nombre) VALUES (5, '56789012', 'Camila Fernández');

-- Insertar datos en la tabla InfoExtraVenta
INSERT INTO InfoExtraVenta (id_infoExtraVenta, cantidad, precioUnitarioVenta) VALUES (1, 10, 5000.00);
INSERT INTO InfoExtraVenta (id_infoExtraVenta, cantidad, precioUnitarioVenta) VALUES (2, 20, 3000.00);
INSERT INTO InfoExtraVenta (id_infoExtraVenta, cantidad, precioUnitarioVenta) VALUES (3, 15, 7000.00);
INSERT INTO InfoExtraVenta (id_infoExtraVenta, cantidad, precioUnitarioVenta) VALUES (4, 30, 4500.00);
INSERT INTO InfoExtraVenta (id_infoExtraVenta, cantidad, precioUnitarioVenta) VALUES (5, 5, 8000.00);

-- Insertar datos en la tabla Venta
INSERT INTO Venta (id_venta, fecha, id_infoExtraVenta, id_cliente) VALUES (1, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 1, 1);
INSERT INTO Venta (id_venta, fecha, id_infoExtraVenta, id_cliente) VALUES (2, TO_DATE('2024-01-02', 'YYYY-MM-DD'), 2, 2);
INSERT INTO Venta (id_venta, fecha, id_infoExtraVenta, id_cliente) VALUES (3, TO_DATE('2024-01-03', 'YYYY-MM-DD'), 3, 3);
INSERT INTO Venta (id_venta, fecha, id_infoExtraVenta, id_cliente) VALUES (4, TO_DATE('2024-01-04', 'YYYY-MM-DD'), 4, 4);
INSERT INTO Venta (id_venta, fecha, id_infoExtraVenta, id_cliente) VALUES (5, TO_DATE('2024-01-05', 'YYYY-MM-DD'), 5, 5);

-- Insertar datos en la tabla Categoria
INSERT INTO Categoria (codigo, nombre, descripcion, caracteristicas) VALUES (1, 'Lácteos', 'Productos derivados de la leche.', 'Leche, Yogur, Queso');
INSERT INTO Categoria (codigo, nombre, descripcion, caracteristicas) VALUES (2, 'Carnes', 'Productos cárnicos de diferentes animales.', 'Res, Cerdo, Pollo');
INSERT INTO Categoria (codigo, nombre, descripcion, caracteristicas) VALUES (3, 'Frutas', 'Alimentos frescos y naturales.', 'Manzanas, Plátanos, Naranjas');
INSERT INTO Categoria (codigo, nombre, descripcion, caracteristicas) VALUES (4, 'Verduras', 'Alimentos vegetales frescos.', 'Zanahorias, Espinacas, Brócoli');
INSERT INTO Categoria (codigo, nombre, descripcion, caracteristicas) VALUES (5, 'Granos', 'Alimentos a base de cereales y legumbres.', 'Arroz, Frijoles, Lentejas');

-- Insertar datos en la tabla ProductoCategoria
INSERT INTO ProductoCategoria (id_producto, codigo_categoria) VALUES (1, 1);
INSERT INTO ProductoCategoria (id_producto, codigo_categoria) VALUES (2, 2);
INSERT INTO ProductoCategoria (id_producto, codigo_categoria) VALUES (3, 3);
INSERT INTO ProductoCategoria (id_producto, codigo_categoria) VALUES (4, 4);
INSERT INTO ProductoCategoria (id_producto, codigo_categoria) VALUES (5, 5);

-- Insertar datos en la tabla OrdenCompra_InfoExtraOrden
INSERT INTO OrdenCompra_InfoExtraOrden (id_ordenCompra, id_infoExtraOrden) VALUES (1, 1);
INSERT INTO OrdenCompra_InfoExtraOrden (id_ordenCompra, id_infoExtraOrden) VALUES (2, 2);
INSERT INTO OrdenCompra_InfoExtraOrden (id_ordenCompra, id_infoExtraOrden) VALUES (3, 3);
INSERT INTO OrdenCompra_InfoExtraOrden (id_ordenCompra, id_infoExtraOrden) VALUES (4, 4);
INSERT INTO OrdenCompra_InfoExtraOrden (id_ordenCompra, id_infoExtraOrden) VALUES (5, 5);

-- Insertar datos en la tabla Producto_InfoExtraOrden
INSERT INTO Producto_InfoExtraOrden (id_producto, id_infoExtraOrden) VALUES (1, 1);
INSERT INTO Producto_InfoExtraOrden (id_producto, id_infoExtraOrden) VALUES (2, 2);
INSERT INTO Producto_InfoExtraOrden (id_producto, id_infoExtraOrden) VALUES (3, 3);
INSERT INTO Producto_InfoExtraOrden (id_producto, id_infoExtraOrden) VALUES (4, 4);
INSERT INTO Producto_InfoExtraOrden (id_producto, id_infoExtraOrden) VALUES (5, 5);

-- Insertar datos en la tabla Bodega_InfoExtraBodega
INSERT INTO Bodega_InfoExtraBodega (id_bodega, id_infoExtraBodega) VALUES (1, 1);
INSERT INTO Bodega_InfoExtraBodega (id_bodega, id_infoExtraBodega) VALUES (2, 2);
INSERT INTO Bodega_InfoExtraBodega (id_bodega, id_infoExtraBodega) VALUES (3, 3);
INSERT INTO Bodega_InfoExtraBodega (id_bodega, id_infoExtraBodega) VALUES (4, 4);
INSERT INTO Bodega_InfoExtraBodega (id_bodega, id_infoExtraBodega) VALUES (5, 5);

-- Insertar datos en la tabla Producto_InfoExtraBodega
INSERT INTO Producto_InfoExtraBodega (id_producto, id_infoExtraBodega) VALUES (1, 1);
INSERT INTO Producto_InfoExtraBodega (id_producto, id_infoExtraBodega) VALUES (2, 2);
INSERT INTO Producto_InfoExtraBodega (id_producto, id_infoExtraBodega) VALUES (3, 3);
INSERT INTO Producto_InfoExtraBodega (id_producto, id_infoExtraBodega) VALUES (4, 4);
INSERT INTO Producto_InfoExtraBodega (id_producto, id_infoExtraBodega) VALUES (5, 5);

-- Insertar datos en la tabla InfoExtraBodega_DetalleCostosBodega
INSERT INTO InfoExtraBodega_DetalleCostosBodega (id_infoExtraBodega, id_detalleCostoBodega) VALUES (1, 1);
INSERT INTO InfoExtraBodega_DetalleCostosBodega (id_infoExtraBodega, id_detalleCostoBodega) VALUES (2, 2);
INSERT INTO InfoExtraBodega_DetalleCostosBodega (id_infoExtraBodega, id_detalleCostoBodega) VALUES (3, 3);
INSERT INTO InfoExtraBodega_DetalleCostosBodega (id_infoExtraBodega, id_detalleCostoBodega) VALUES (4, 4);
INSERT INTO InfoExtraBodega_DetalleCostosBodega (id_infoExtraBodega, id_detalleCostoBodega) VALUES (5, 5);

-- Insertar datos en la tabla Producto_InfoExtraProveedor
INSERT INTO Producto_InfoExtraProveedor (id_producto, id_infoExtraProveedor) VALUES (1, 1);
INSERT INTO Producto_InfoExtraProveedor (id_producto, id_infoExtraProveedor) VALUES (2, 2);
INSERT INTO Producto_InfoExtraProveedor (id_producto, id_infoExtraProveedor) VALUES (3, 3);
INSERT INTO Producto_InfoExtraProveedor (id_producto, id_infoExtraProveedor) VALUES (4, 4);
INSERT INTO Producto_InfoExtraProveedor (id_producto, id_infoExtraProveedor) VALUES (5, 5);

-- Insertar datos en la tabla Proveedor_InfoExtraProveedor
INSERT INTO Proveedor_InfoExtraProveedor (NIT, id_infoExtraProveedor) VALUES ('123456789', 1);
INSERT INTO Proveedor_InfoExtraProveedor (NIT, id_infoExtraProveedor) VALUES ('987654321', 2);
INSERT INTO Proveedor_InfoExtraProveedor (NIT, id_infoExtraProveedor) VALUES ('456789123', 3);
INSERT INTO Proveedor_InfoExtraProveedor (NIT, id_infoExtraProveedor) VALUES ('321654987', 4);
INSERT INTO Proveedor_InfoExtraProveedor (NIT, id_infoExtraProveedor) VALUES ('159753456', 5);

-- Insertar datos en la tabla Venta_InfoExtraVenta
INSERT INTO Venta_InfoExtraVenta (id_venta, id_infoExtraVenta) VALUES (1, 1);
INSERT INTO Venta_InfoExtraVenta (id_venta, id_infoExtraVenta) VALUES (2, 2);
INSERT INTO Venta_InfoExtraVenta (id_venta, id_infoExtraVenta) VALUES (3, 3);
INSERT INTO Venta_InfoExtraVenta (id_venta, id_infoExtraVenta) VALUES (4, 4);
INSERT INTO Venta_InfoExtraVenta (id_venta, id_infoExtraVenta) VALUES (5, 5);


-- Insertar datos en la tabla Producto_InfoExtraVenta
INSERT INTO Producto_InfoExtraVenta (id_producto, id_infoExtraVenta) VALUES (1, 1);
INSERT INTO Producto_InfoExtraVenta (id_producto, id_infoExtraVenta) VALUES (2, 2);
INSERT INTO Producto_InfoExtraVenta (id_producto, id_infoExtraVenta) VALUES (3, 3);
INSERT INTO Producto_InfoExtraVenta (id_producto, id_infoExtraVenta) VALUES (4, 4);
INSERT INTO Producto_InfoExtraVenta (id_producto, id_infoExtraVenta) VALUES (5, 5);
