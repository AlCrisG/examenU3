# Roles
El sistema va a contar con los **6 roles** siguientes:

- **Cliente**
- **Empleado**
    - **Gerente de sucursal**
    - **Ejecutivo de cuenta**
    - **Capturista**
- **Inversionistas**
## Clientes
Tan solo puede ser dado de alta por los **ejecutivos de cuenta** y **gerentes**, al momento de darse de alta, se les asigna una **tarjeta de débito**.
Los datos que se ocupan para dar de alta al usuario:

| Datos                |           |                   |
|----------------------|-----------|-------------------|
| Nombre               | Apellidos | Año de nacimiento |
| Ciudad               | Estado    | RFC               |
| CURP                 | Dirección | Fecha de registro |
| Sucursal de registro |           |                   |

## Empleados
Solo pueden realizar las operaciones que les corresponden en la sucursal a la que pertenecen.

| Datos   |           |                             |
|---------|-----------|-----------------------------|
| Nombre  | Apellidos | Año de nacimiento           |
| Ciudad  | Estado    | RFC                         |
| CURP    | Dirección | Sucursal a la que pertenece |
| Salario | Rol       | Fecha de inicio de trabajo  |

### Gerente de sucursal
Esta persona podrá hacer todas las operaciones con las que cuente el sistema (**puede hacer todo lo que hace un capturista y ejecutivo de venta**), puede registrar, modificar y eliminar por el gerente y para ello ocupa de una **contraseña**.

#### Es importante señalar que se debe registrar un gerente por default en cada sucursal y solo puede haber uno.

### Capturista
Se encarga del registro o modificación de los ejecutivos de cuenta.

### Ejecutivo de cuenta
Está encargada de llevar todo el proceso de los clientes. Registrar, modificar, eliminar, buscar, etc. De igual forma, puede autorizar la solicitud de tarjeta de crédito.

## Inversionistas
Se encarga de proveer de fondos al banco, una vez registrado, este podrá entrar a su perfil y proveer fondos al banco y el gerente puede ver quien lo hizo, cuando lo hizo y cuanto.

## Tarjetas
Cada cliente puede ver las tarjetas con las que cuenta, de estas tarjetas, un cliente puede tener máximo 1 tarjeta de débito y hasta 3 tarjetas de crédito.
Las tarjetas de crédito se dividen en 3: _**simplicity**_, _**platino**_ y _**oro**_. El cliente podrá solicitar las tarjetas una vez que tenga en la tarjeta de débito o una cantidad mayor $50,000, $100,000 y $200,000, respectivamente.

- **Tarjeta simplicity** Máximo de $60,000
- **Tarjeta platino** Máximo de $150,000
- **Tarjeta de oro** Máximo de $400,000

Al momento en el que el cliente hace una compra con una tarjeta de crédito, restarle esa cantidad de su crédito máximo, esto para asegurar que no puede gastar más de lo que tiene permitido. Para poder gastar más con su tarjeta, debe de realizar el pago de ella para que su crédito vuelve a subir.

| Datos                                                                           |                     |                               |
|---------------------------------------------------------------------------------|---------------------|-------------------------------|
| Número de tarjeta                                                               | Fecha de creación   | Saldo                         |
| CVV                                                                             | CLABE interbancaria | Fecha de vencimiento (5 años) |
| Fecha y hora de último<br/>(se actualiza cada vez que se realiza un movimiento) |                     |                               |

Es importante resaltar que una vez que el sistema detecte que el cliente tiene la cantidad permitida para solicitar alguna tarjeta, se le habilite una opción para solicitar, y dependiendo de su saldo, que solicite la tarjeta correspondiente, caso contrario que no le aparezca la opción de solicitud.
Una vez que un cliente pueda solicitar una tarjeta de crédito debido a que cuenta con fondos suficientes, y seleccione esa opción, se generará una solicitud que podrá ver el ejecutivo de cuenta y el gerente, donde ellos podrán aceptarla o rechazarla, y en caso de aceptarla, se generará una tarjeta y se le asociará al cliente.
Los datos que se piden en una solicitud de tarjeta:

| Datos                                                 |                                          |                              |
|-------------------------------------------------------|------------------------------------------|------------------------------|
| Cliente que solicita                                  | Fecha de solicitud                       | Tipo de tarjeta que solicita |
| Monto en tarjeta de debido al momento de la solicitud | Status: En proceso, aprobada y rechazada | ID de cliente                |

Es importante resaltar que el cliente no podrá realizar múltiples solicitudes es decir, si desea realizar otra, debe de esperar a que la anterior cambie a **aprobada** o **rechazada**.
De igual forma, el cliente podrá realizar los movimientos comunes con sus tarjetas, es decir, depositar y retirar.

# Notas
- Cada usuario debe contar con su propia contraseña.
- Todos los movimientos son únicos por sucursal, es decir, algún ejecutivo de la sucursal A no podrá ver ni realizar movimientos de la sucursal B.
- Realizar todas las validaciones correspondientes, ej. no ID’s duplicados, que existan objetos antes de crear relaciones, que si se eliminan objetos no rompan otras relaciones, etc.