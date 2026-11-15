

<!-- local-development:start -->
# Desarrollo local

Puedes abrir este repositorio en VS Code, Antigravity o Sublime Text. El compilador y los servicios necesarios dependen del componente indicado abajo.

## Java / NetBeans

En NetBeans 25, abre la carpeta que contiene `build.xml` como proyecto Ant. Selecciona un JDK igual o posterior al nivel de fuente del proyecto; las compilaciones de esta revisión usan JDK 24.0.2. El asistente busca NetBeans y el JDK y mantiene la configuración de usuario en `.local-build/`.

```powershell
.uild-local.ps1
.\build-local.ps1 -Project 'BuscaminasUTN/build.xml' -Target run
```

Si hay varios proyectos, elige el deseado con `-Project`. Puedes indicar `-JavaHome` y `-NetBeansHome`. `-Target test` ejecuta las pruebas que declare el proyecto; un objetivo de pruebas vacío no acredita cobertura.

## Maven

Abre el `pom.xml` correspondiente en NetBeans. Usa `mvn test` en su carpeta después de revisar plugins y perfiles. Las compilaciones Java/Ant de la tabla no cubren los componentes Maven.

## Componentes y validación

Inventario y compilaciones locales del 2026-11-15. Una compilación correcta no acredita todavía interacción, compatibilidad de base de datos, instalador ni despliegue.

| Componente | Tipo / destino | Validación |
| --- | --- | --- |
| [BuscaminasUTN/build.xml](<BuscaminasUTN/build.xml>) | netbeans-ant / 24 | Compila; comprobado el 2026-11-15; ver alcance actualizado abajo |
| [PuraVida_MiPyME/pom.xml](<PuraVida_MiPyME/pom.xml>) | maven | Compila; comprobado el 2026-11-15; ver alcance actualizado abajo |

## Archivos ignorados

`.gitignore` excluye credenciales locales, estado del editor y salidas de las herramientas detectadas. No deja de versionar archivos que ya estaban en Git. Los manifiestos, archivos de bloqueo, recursos fuente y scripts de esquema forman parte del código.
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
