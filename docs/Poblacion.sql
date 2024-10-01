-- Insertar datos en la tabla Ciudad
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (1, 'Bogotá', 11001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (2, 'Medellín', 5001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (3, 'Cali', 76001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (4, 'Barranquilla', 8001);
INSERT INTO Ciudad (id_ciudad, nombre, codigo) VALUES (5, 'Cartagena', 13001);

-- Insertar datos en la tabla Sucursal
INSERT INTO Sucursal (id_sucursal, nombre, tamaño, direccion, telefono, id_ciudad) VALUES (1, 'Supermercado Éxito La 26', 200.00, 'Av. La 26 #45-01', '3001234567', 1);
INSERT INTO Sucursal (id_sucursal, nombre, tamaño, direccion, telefono, id_ciudad) VALUES (2, 'Carulla Calle 72', 180.00, 'Calle 72 #11-45', '3002345678', 1);
INSERT INTO Sucursal (id_sucursal, nombre, tamaño, direccion, telefono, id_ciudad) VALUES (3, 'Jumbo Medellín', 220.00, 'Carrera 65 #34-67', '3003456789', 2);
INSERT INTO Sucursal (id_sucursal, nombre, tamaño, direccion, telefono, id_ciudad) VALUES (4, 'Ara Cali', 150.00, 'Carrera 2 #22-10', '3004567890', 3);
INSERT INTO Sucursal (id_sucursal, nombre, tamaño, direccion, telefono, id_ciudad) VALUES (5, 'OXXO Barranquilla', 80.00, 'Calle 30 #10-05', '3005678901', 4);

-- Insertar datos en la tabla InfoExtraBodega
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (1, 1000.00, 30, 150, 500.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (2, 1500.00, 25, 200, 600.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (3, 800.00, 20, 100, 300.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (4, 1200.00, 35, 250, 700.00);
INSERT INTO InfoExtraBodega (id_infoExtraBodega, costoPromedio, nivelMinReorden, totalExistencias, capacidadAlmacenamiento) VALUES (5, 900.00, 15, 180, 450.00);

-- Insertar datos en la tabla EspecificacionEmpacado
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (1, 1.00, 0.5);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (2, 0.5, 0.3);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (3, 1.50, 1.0);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (4, 2.00, 1.5);
INSERT INTO EspecificacionEmpacado (id_especificacionEmpacado, volumen, peso) VALUES (5, 0.75, 0.4);

-- Insertar datos en la tabla Producto
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (1, '1234567890123', 'Arroz Costeño', 2500.00, 'Paquete', 1, 'kg', TO_DATE('2024-12-01', 'YYYY-MM-DD'), 1);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (2, '9876543210987', 'Frijol Rojo', 3000.00, 'Paquete', 1, 'kg', TO_DATE('2024-11-15', 'YYYY-MM-DD'), 2);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (3, '1112223334445', 'Aceite de Girasol', 4500.00, 'Botella', 1, 'litro', TO_DATE('2025-01-20', 'YYYY-MM-DD'), 3);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (4, '5556667778889', 'Salsa de Tomate', 1500.00, 'Tarro', 1, 'litro', TO_DATE('2024-10-05', 'YYYY-MM-DD'), 4);
INSERT INTO Producto (id_producto, codigoBarras, nombre, precioUnitarioVenta, presentacion, cantidadPresentacion, unidadMedida, fechaExpiracion, id_especificacionEmpacado) VALUES (5, '3334445556667', 'Leche Entera', 2800.00, 'Botella', 1, 'litro', TO_DATE('2024-10-25', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla Bodega
INSERT INTO Bodega (id_bodega, nombre, tamaño, id_sucursal, id_infoExtraBodega) VALUES (1, 'Bodega Centro Bogotá', 300.00, 1, 1);
INSERT INTO Bodega (id_bodega, nombre, tamaño, id_sucursal, id_infoExtraBodega) VALUES (2, 'Bodega Norte Medellín', 250.00, 3, 2);
INSERT INTO Bodega (id_bodega, nombre, tamaño, id_sucursal, id_infoExtraBodega) VALUES (3, 'Bodega Cali Sur', 350.00, 4, 3);
INSERT INTO Bodega (id_bodega, nombre, tamaño, id_sucursal, id_infoExtraBodega) VALUES (4, 'Bodega Barranquilla', 200.00, 5, 4);
INSERT INTO Bodega (id_bodega, nombre, tamaño, id_sucursal, id_infoExtraBodega) VALUES (5, 'Bodega Cartagena', 150.00, 2, 5);

-- Insertar datos en la tabla DetalleCostoBodega
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_infoExtraBodega) VALUES (1, 1000.00, 50, 1);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_infoExtraBodega) VALUES (2, 1200.00, 30, 2);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_infoExtraBodega) VALUES (3, 800.00, 20, 3);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_infoExtraBodega) VALUES (4, 900.00, 25, 4);
INSERT INTO DetalleCostoBodega (id_detalleCostoBodega, costoUnitarioBodega, cantidadExistencias, id_infoExtraBodega) VALUES (5, 1100.00, 40, 5);

-- Insertar datos en la tabla ProductoPerecedero
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento, id_producto) VALUES (1, TO_DATE('2024-10-01', 'YYYY-MM-DD'), 1);
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento, id_producto) VALUES (2, TO_DATE('2024-09-30', 'YYYY-MM-DD'), 2);
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento, id_producto) VALUES (3, TO_DATE('2025-01-01', 'YYYY-MM-DD'), 3);
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento, id_producto) VALUES (4, TO_DATE('2024-10-05', 'YYYY-MM-DD'), 4);
INSERT INTO ProductoPerecedero (id_productoPerecedero, fechaVencimiento, id_producto) VALUES (5, TO_DATE('2024-10-25', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla InfoExtraOrden
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (1, 100, 2400.00);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (2, 150, 2700.00);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (3, 80, 2900.00);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (4, 200, 2600.00);
INSERT INTO InfoExtraOrden (id_infoExtraOrden, cantidad, costoUnitarioCompra) VALUES (5, 120, 3000.00);

-- Insertar datos en la tabla OrdenCompra
INSERT INTO OrdenCompra (id_OrdenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (1, TO_DATE('2024-09-01', 'YYYY-MM-DD'), 'Pendiente', TO_DATE('2024-09-10', 'YYYY-MM-DD'), 1);
INSERT INTO OrdenCompra (id_OrdenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (2, TO_DATE('2024-09-05', 'YYYY-MM-DD'), 'Completada', TO_DATE('2024-09-12', 'YYYY-MM-DD'), 2);
INSERT INTO OrdenCompra (id_OrdenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (3, TO_DATE('2024-09-10', 'YYYY-MM-DD'), 'Cancelada', NULL, 3);
INSERT INTO OrdenCompra (id_OrdenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (4, TO_DATE('2024-09-15', 'YYYY-MM-DD'), 'Pendiente', TO_DATE('2024-09-20', 'YYYY-MM-DD'), 4);
INSERT INTO OrdenCompra (id_OrdenCompra, fechaCreacion, estado, fechaEntrega, id_infoExtraOrden) VALUES (5, TO_DATE('2024-09-20', 'YYYY-MM-DD'), 'Completada', TO_DATE('2024-09-25', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla RecepcionProducto
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_producto) VALUES (1, TO_DATE('2024-09-05', 'YYYY-MM-DD'), 1);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_producto) VALUES (2, TO_DATE('2024-09-12', 'YYYY-MM-DD'), 2);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_producto) VALUES (3, TO_DATE('2024-09-10', 'YYYY-MM-DD'), 3);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_producto) VALUES (4, TO_DATE('2024-09-20', 'YYYY-MM-DD'), 4);
INSERT INTO RecepcionProducto (id_recepcionProducto, fechaRecepcion, id_producto) VALUES (5, TO_DATE('2024-09-25', 'YYYY-MM-DD'), 5);

-- Insertar datos en la tabla InfoExtraProveedor
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (1, 500);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (2, 300);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (3, 700);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (4, 100);
INSERT INTO InfoExtraProveedor (id_infoExtraProveedor, cantidadExistencias) VALUES (5, 450);

-- Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('900123456-7', 'Alimentos S.A.', 'Calle 100 #10-20', 'Juan Pérez', '3001234567', 1);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('800765432-1', 'Proveedores de Leche', 'Calle 72 #15-35', 'María Gómez', '3002345678', 2);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('700987654-3', 'Distribuidores de Aceite', 'Carrera 50 #20-40', 'Carlos López', '3003456789', 3);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('600345678-5', 'Fabrica de Salsas', 'Carrera 30 #50-10', 'Ana Rodríguez', '3004567890', 4);
INSERT INTO Proveedor (NIT, nombre, direccion, nombre_contacto, telefono, id_infoExtraProveedor) VALUES ('500678901-7', 'Granos y Cereales', 'Calle 50 #12-30', 'Luis Torres', '3005678901', 5);

-- Insertar datos en la tabla InfoExtraProducto
INSERT INTO InfoExtraProducto (id_infoExtraProducto, cantidadMinima, cantidadMaxima) VALUES (1, 10, 100);
INSERT INTO InfoExtraProducto (id_infoExtraProducto, cantidadMinima, cantidadMaxima) VALUES (2, 5, 80);
INSERT INTO InfoExtraProducto (id_infoExtraProducto, cantidadMinima, cantidadMaxima) VALUES (3, 20, 200);
INSERT INTO InfoExtraProducto (id_infoExtraProducto, cantidadMinima, cantidadMaxima) VALUES (4, 15, 150);
INSERT INTO InfoExtraProducto (id_infoExtraProducto, cantidadMinima, cantidadMaxima) VALUES (5, 12, 120);

-- Insertar datos en la tabla DetalleInventario
INSERT INTO DetalleInventario (id_detalleInventario, id_producto, id_bodega, cantidadExistencias) VALUES (1, 1, 1, 50);
INSERT INTO DetalleInventario (id_detalleInventario, id_producto, id_bodega, cantidadExistencias) VALUES (2, 2, 2, 30);
INSERT INTO DetalleInventario (id_detalleInventario, id_producto, id_bodega, cantidadExistencias) VALUES (3, 3, 3, 20);
INSERT INTO DetalleInventario (id_detalleInventario, id_producto, id_bodega, cantidadExistencias) VALUES (4, 4, 4, 25);
INSERT INTO DetalleInventario (id_detalleInventario, id_producto, id_bodega, cantidadExistencias) VALUES (5, 5, 5, 40);

-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (id_cliente, nombre, documento_identidad, telefono, direccion, email) VALUES (1, 'Andrés Martínez', '123456789', '3001112233', 'Calle 1 #10-20', 'andres.martinez@email.com');
INSERT INTO Cliente (id_cliente, nombre, documento_identidad, telefono, direccion, email) VALUES (2, 'Laura Gómez', '987654321', '3002223344', 'Calle 2 #20-30', 'laura.gomez@email.com');
INSERT INTO Cliente (id_cliente, nombre, documento_identidad, telefono, direccion, email) VALUES (3, 'Carlos Fernández', '456789123', '3003334455', 'Calle 3 #30-40', 'carlos.fernandez@email.com');
INSERT INTO Cliente (id_cliente, nombre, documento_identidad, telefono, direccion, email) VALUES (4, 'Ana Ruiz', '321654987', '3004445566', 'Calle 4 #40-50', 'ana.ruiz@email.com');
INSERT INTO Cliente (id_cliente, nombre, documento_identidad, telefono, direccion, email) VALUES (5, 'Pedro Sánchez', '159753456', '3005556677', 'Calle 5 #50-60', 'pedro.sanchez@email.com');

-- Insertar datos en la tabla Venta
INSERT INTO Venta (id_venta, fecha_venta, total, id_cliente, id_producto, cantidad) VALUES (1, TO_DATE('2024-09-01', 'YYYY-MM-DD'), 5000.00, 1, 1, 2);
INSERT INTO Venta (id_venta, fecha_venta, total, id_cliente, id_producto, cantidad) VALUES (2, TO_DATE('2024-09-05', 'YYYY-MM-DD'), 6000.00, 2, 2, 2);
INSERT INTO Venta (id_venta, fecha_venta, total, id_cliente, id_producto, cantidad) VALUES (3, TO_DATE('2024-09-10', 'YYYY-MM-DD'), 7000.00, 3, 3, 2);
INSERT INTO Venta (id_venta, fecha_venta, total, id_cliente, id_producto, cantidad) VALUES (4, TO_DATE('2024-09-15', 'YYYY-MM-DD'), 8000.00, 4, 4, 2);
INSERT INTO Venta (id_venta, fecha_venta, total, id_cliente, id_producto, cantidad) VALUES (5, TO_DATE('2024-09-20', 'YYYY-MM-DD'), 9000.00, 5, 5, 3);

