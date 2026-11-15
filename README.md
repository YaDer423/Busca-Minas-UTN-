# Busca-Minas-UTN-

<!-- local-development:start -->
## Desarrollo local

Consulta [RUNNING.md](RUNNING.md) para ubicar cada componente, abrirlo en su IDE, compilarlo y conocer las comprobaciones realizadas y los requisitos pendientes.
<!-- local-development:end -->

<!-- build-repairs-20261115:start -->
## Reparación y comprobación — 2026-11-15

- Buscaminas corrige el nombre de columna, el cálculo de adyacencias, acceso a banderas y la validación del tamaño del tablero.
- PuraVida_MiPyME corrige el constructor de PropertyChangeSupportMixim y restaura una comprobación ejecutable del dominio Producto → ItemOrden → Orden que el main referenciaba pero no incluía.

Comprobado:

- Compilan Ant/Buscaminas y Maven/PuraVida_MiPyME.
- SmokeTablero verificó minas, adyacencias y banderas en tamaños de 2 a 12, y el rechazo del tamaño 1.
- El main de PuraVida verificó importes decimales, recálculo y cambio de cantidades.

Comandos:

```powershell
.\build-local.ps1
.\test-local.ps1
mvn -f PuraVida_MiPyME/pom.xml package
```

Alcance pendiente:

- PuraVida_MiPyME sigue siendo una comprobación de dominio: no incluye una GUI de inventario terminada.

<!-- build-repairs-20261115:end -->
