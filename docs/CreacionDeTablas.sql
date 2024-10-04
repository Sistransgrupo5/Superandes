-- Tabla Ciudad
CREATE TABLE Ciudad (
    id_ciudad INT PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    codigo INT NOT NULL
);

-- Tabla Sucursal
CREATE TABLE Sucursal (
    id_sucursal INT PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tamanio DECIMAL(10, 2) NOT NULL,
    direccion VARCHAR2(255) NOT NULL,
    telefono VARCHAR2(20) NOT NULL,
    id_ciudad INT,
    FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id_ciudad)
);

-- Tabla InfoExtraBodega
CREATE TABLE InfoExtraBodega (
    id_bodega INT NOT NULL,
    id_producto INT NOT NULL,
    costoPromedio DECIMAL(10, 2) NOT NULL,
    nivelMinReorden INT CHECK (nivelMinReorden > 25),
    totalExistencias INT NOT NULL,
    capacidadAlmacenamiento DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id_bodega, id_producto),  -- Clave primaria compuesta
    FOREIGN KEY (id_bodega) REFERENCES Bodega(id_bodega),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
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
    codigoBarras VARCHAR2(50) UNIQUE NOT NULL,
    nombre VARCHAR2(100) NOT NULL,
    precioUnitarioVenta DECIMAL(10, 2) NOT NULL,
    presentacion VARCHAR2(50) NOT NULL,
    cantidadPresentacion INT NOT NULL,
    unidadMedida VARCHAR2(20) NOT NULL,
    fechaExpiracion DATE,
    id_especificacionEmpacado INT,
    FOREIGN KEY (id_especificacionEmpacado) REFERENCES EspecificacionEmpacado(id_especificacionEmpacado)
);

-- Tabla Bodega
CREATE TABLE Bodega (
    id_bodega INT PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tamanio DECIMAL(10, 2) NOT NULL,
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
    id_bodega INT NOT NULL,
    FOREIGN KEY (id_bodega) REFERENCES Bodega(id_bodega)  -- Referencia a Bodega
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
    id_ordenCompra INT PRIMARY KEY,
    fechaCreacion DATE NOT NULL,
    estado VARCHAR2(50) NOT NULL,
    fechaEntrega DATE,
    id_infoExtraOrden INT,
    FOREIGN KEY (id_infoExtraOrden) REFERENCES InfoExtraOrden(id_infoExtraOrden)
);

-- Tabla RecepcionProducto
CREATE TABLE RecepcionProducto (
    id_recepcionProducto INT PRIMARY KEY,
    fechaRecepcion DATE NOT NULL,
    id_ordenCompra INT NOT NULL,
    id_bodega INT NOT NULL,
    FOREIGN KEY (id_ordenCompra) REFERENCES OrdenCompra(id_ordenCompra),
    FOREIGN KEY (id_bodega) REFERENCES Bodega(id_bodega)
);

-- Tabla InfoExtraProveedor
CREATE TABLE InfoExtraProveedor (
    id_infoExtraProveedor INT PRIMARY KEY,
    cantidadExistencias INT NOT NULL
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    NIT VARCHAR2(20) PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    direccion VARCHAR2(255) NOT NULL,
    nombre_contacto VARCHAR2(100) NOT NULL,
    telefono VARCHAR2(20) NOT NULL,
    id_infoExtraProveedor INT,
    FOREIGN KEY (id_infoExtraProveedor) REFERENCES InfoExtraProveedor(id_infoExtraProveedor)  -- Correcto, se ha agregado el ID
);

-- Tabla Cliente
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    cedula VARCHAR2(20) NOT NULL UNIQUE,
    nombre VARCHAR2(100) NOT NULL
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
    nombre VARCHAR2(100) NOT NULL,
    descripcion VARCHAR2(255) NOT NULL,
    caracteristicas VARCHAR2(255) NOT NULL
);

-- Tabla ProductoCategoria (Relación entre Producto y Categoria)
CREATE TABLE ProductoCategoria (
    id_producto INT,
    codigo_categoria INT,
    PRIMARY KEY (id_producto, codigo_categoria),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (codigo_categoria) REFERENCES Categoria(codigo)
);

-- Tabla_Clase de asociación: OrdenCompra - InfoExtraOrden
CREATE TABLE OrdenCompra_InfoExtraOrden (
    id_ordenCompra INT,
    id_infoExtraOrden INT,
    PRIMARY KEY (id_ordenCompra, id_infoExtraOrden),
    FOREIGN KEY (id_ordenCompra) REFERENCES OrdenCompra(id_ordenCompra),
    FOREIGN KEY (id_infoExtraOrden) REFERENCES InfoExtraOrden(id_infoExtraOrden)
);

-- Tabla_Clase de asociación: Producto - InfoExtraOrden
CREATE TABLE Producto_InfoExtraOrden (
    id_producto INT,
    id_infoExtraOrden INT,
    PRIMARY KEY (id_producto, id_infoExtraOrden),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_infoExtraOrden) REFERENCES InfoExtraOrden(id_infoExtraOrden)
);

-- Tabla_Clase de asociación: Bodega - InfoExtraBodega
CREATE TABLE Bodega_InfoExtraBodega (
    id_bodega INT,
    id_infoExtraBodega INT,
    PRIMARY KEY (id_bodega, id_infoExtraBodega),
    FOREIGN KEY (id_bodega) REFERENCES Bodega(id_bodega),
    FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega)
);

-- Tabla_Clase de asociación: Producto - InfoExtraBodega
CREATE TABLE Producto_InfoExtraBodega (
    id_producto INT,
    id_infoExtraBodega INT,
    PRIMARY KEY (id_producto, id_infoExtraBodega),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega)
);

-- Tabla_Clase de asociación: InfoExtraBodega - DetalleCostosBodega
CREATE TABLE InfoExtraBodega_DetalleCostosBodega (
    id_infoExtraBodega INT,
    id_detalleCostoBodega INT,
    PRIMARY KEY (id_infoExtraBodega, id_detalleCostoBodega),
    FOREIGN KEY (id_infoExtraBodega) REFERENCES InfoExtraBodega(id_infoExtraBodega),
    FOREIGN KEY (id_detalleCostoBodega) REFERENCES DetalleCostoBodega(id_detalleCostoBodega)
);

-- Tabla_Clase de asociación: Producto - InfoExtraProveedor
CREATE TABLE Producto_InfoExtraProveedor (
    id_producto INT,
    id_infoExtraProveedor INT,
    PRIMARY KEY (id_producto, id_infoExtraProveedor),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_infoExtraProveedor) REFERENCES InfoExtraProveedor(id_infoExtraProveedor)
);

-- Tabla_Clase de asociación: Proveedor - InfoExtraProveedor
CREATE TABLE Proveedor_InfoExtraProveedor (
    NIT VARCHAR2(20),
    id_infoExtraProveedor INT,
    PRIMARY KEY (NIT, id_infoExtraProveedor),
    FOREIGN KEY (NIT) REFERENCES Proveedor(NIT),
    FOREIGN KEY (id_infoExtraProveedor) REFERENCES InfoExtraProveedor(id_infoExtraProveedor)
);

-- Tabla_Clase de asociación: Venta - InfoExtraVenta
CREATE TABLE Venta_InfoExtraVenta (
    id_venta INT,
    id_infoExtraVenta INT,
    PRIMARY KEY (id_venta, id_infoExtraVenta),
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
    FOREIGN KEY (id_infoExtraVenta) REFERENCES InfoExtraVenta(id_infoExtraVenta)
);

-- Tabla_Clase de asociación: Producto - InfoExtraVenta
CREATE TABLE Producto_InfoExtraVenta (
    id_producto INT,
    id_infoExtraVenta INT,
    PRIMARY KEY (id_producto, id_infoExtraVenta),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_infoExtraVenta) REFERENCES InfoExtraVenta(id_infoExtraVenta)
);
