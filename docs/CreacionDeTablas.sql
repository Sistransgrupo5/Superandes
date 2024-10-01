-- Tabla Ciudad
CREATE TABLE Ciudad (
    id_ciudad INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo INT NOT NULL
);

-- Tabla Sucursal
CREATE TABLE Sucursal (
    id_sucursal INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tamaño DECIMAL(10, 2) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    id_ciudad INT,
    FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id_ciudad)
);

-- Tabla InfoExtraBodega
CREATE TABLE InfoExtraBodega (
    id_infoExtraBodega INT PRIMARY KEY,
    costoPromedio DECIMAL(10, 2) NOT NULL,
    nivelMinReorden INT CHECK (nivelMinReorden > 25),
    totalExistencias INT NOT NULL,
    capacidadAlmacenamiento DECIMAL(10, 2) NOT NULL
);

-- Tabla EspecificacionEmpacado
CREATE TABLE EspecificacionEmpacado (
    id_especificacionEmpacado INT PRIMARY KEY,
    volumen DECIMAL(10, 2) NOT NULL,
    peso DECIMAL(10, 2) NOT NULL
);

-- Tabla Producto
CREATE TABLE Producto (
    id_producto INT PRIMARY KEY,
    codigoBarras VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    precioUnitarioVenta DECIMAL(10, 2) NOT NULL,
    presentacion VARCHAR(50) NOT NULL,
    cantidadPresentacion INT NOT NULL,
    unidadMedida VARCHAR(20) NOT NULL,
    fechaExpiracion DATE,
    id_especificacionEmpacado INT,
    FOREIGN KEY (id_especificacionEmpacado) REFERENCES EspecificacionEmpacado(id_especificacionEmpacado)
);

-- Tabla Bodega
CREATE TABLE Bodega (
    id_bodega INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tamaño DECIMAL(10, 2) NOT NULL,
    id_sucursal INT,
    id_infoExtraBodega INT,
    FOREIGN KEY (id_sucursal) REFERENCES Sucursal(id_sucursal),
    FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega)
);

-- Tabla DetalleCostoBodega
CREATE TABLE DetalleCostoBodega (
    id_detalleCostoBodega INT PRIMARY KEY,
    costoUnitarioBodega DECIMAL(10, 2) NOT NULL,
    cantidadExistencias INT NOT NULL,
    id_infoExtraBodega INT,
    FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega)
);

-- Tabla ProductoPerecedero (Herencia de Producto)
CREATE TABLE ProductoPerecedero (
    id_productoPerecedero INT PRIMARY KEY,
    fechaVencimiento DATE NOT NULL,
    FOREIGN KEY (id_productoPerecedero) REFERENCES Producto(id_producto)
);

-- Tabla InfoExtraOrden
CREATE TABLE InfoExtraOrden (
    id_infoExtraOrden INT PRIMARY KEY,
    cantidad INT NOT NULL,
    costoUnitarioCompra DECIMAL(10, 2) NOT NULL
);

-- Tabla OrdenCompra
CREATE TABLE OrdenCompra (
    id_OrdenCompra INT PRIMARY KEY,
    fechaCreacion DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fechaEntrega DATE,
    id_infoExtraOrden INT,
    FOREIGN KEY (id_infoExtraOrden) REFERENCES InfoExtraOrden(id_infoExtraOrden)
);

-- Tabla RecepcionProducto
CREATE TABLE RecepcionProducto (
    id_recepcionProducto INT PRIMARY KEY,
    fechaRecepcion DATE NOT NULL,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- Tabla InfoExtraProveedor
CREATE TABLE InfoExtraProveedor (
    id_infoExtraProveedor INT PRIMARY KEY,
    cantidadExistencias INT NOT NULL
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    NIT VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    nombre_contacto VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    id_infoExtraProveedor INT,
    FOREIGN KEY (id_infoExtraProveedor) REFERENCES InfoExtraProveedor(id_infoExtraProveedor)
);

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla InfoExtraVenta
CREATE TABLE InfoExtraVenta (
    id_infoExtraVenta INT PRIMARY KEY,
    cantidad INT NOT NULL,
    precioUnitarioVenta DECIMAL(10, 2) NOT NULL
);

-- Tabla Venta
CREATE TABLE Venta (
    id_venta INT PRIMARY KEY,
    fecha DATE NOT NULL,
    id_infoExtraVenta INT,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_infoExtraVenta) REFERENCES InfoExtraVenta(id_infoExtraVenta),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabla Categoria
CREATE TABLE Categoria (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    caracteristicas VARCHAR(255) NOT NULL,
    id_producto INT,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-- Relación entre Producto y Categoria
ALTER TABLE Categoria
ADD CONSTRAINT fk_producto_categoria
FOREIGN KEY (id_producto) REFERENCES Producto(id_producto);

-- Relación entre Producto y DetalleCostoBodega
ALTER TABLE DetalleCostoBodega
ADD CONSTRAINT fk_producto_detallecostobodega
FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega);

-- Relación entre Proveedor e InfoExtraProveedor
ALTER TABLE Proveedor
ADD CONSTRAINT fk_proveedor_infoextraproveedor
FOREIGN KEY (id_infoExtraProveedor) REFERENCES InfoExtraProveedor(id_infoExtraProveedor);

-- Relación entre Venta e InfoExtraVenta
ALTER TABLE Venta
ADD CONSTRAINT fk_venta_infoextraventa
FOREIGN KEY (id_infoExtraVenta) REFERENCES InfoExtraVenta(id_infoExtraVenta);

-- Relación entre Venta y Cliente
ALTER TABLE Venta
ADD CONSTRAINT fk_venta_cliente
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente);

-- Relación entre OrdenCompra e InfoExtraOrden
ALTER TABLE OrdenCompra
ADD CONSTRAINT fk_ordencompra_infoextraorden
FOREIGN KEY (id_infoExtraOrden) REFERENCES InfoExtraOrden(id_infoExtraOrden);