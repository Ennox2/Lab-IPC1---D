# Versionamiento 

Descripción de algunos comandos comunes de Git junto con sus respectivos códigos (pueden ser ejecutados en consola cmd, Git Bash, terminal de Visual Studio Code, entre otros):

### Comandos principales 📥
- **Clonar un repositorio remoto:**
  ```
  git clone url_del_repositorio
  ```
   Clona un repositorio remoto en el directorio actual.

- **Agregar cambios al área de preparación:**
  ```
  git add nombre_del_archivo
  ```
  Agrega cambios de un archivo específico al área de preparación.
   ```
  git add .
  ```
  Agregar todos los cambios al área de preparación. 

- **Confirmar cambios:**
  ```
  git commit -m "Mensaje descriptivo"
  ```
  Confirma los cambios con un mensaje descriptivo.

- **Enviar cambios al repositorio remoto:**
  ```
  git push nombre_remoto nombre_rama
  ```
  Envía cambios al repositorio remoto.

- **Obtener cambios del repositorio remoto:** 
    ```
    git pull nombre_remoto nombre_rama
    ```
    Obtiene y fusiona cambios desde el repositorio remoto.

### Configuración inicial 🔄 
- **Configurar nombre de usuario:**
  ```bash
  git config --global user.name "Tu Nombre"
  ```
  Configura el nombre del usuario.

- **Configurar correo electrónico:**
  ```bash
  git config --global user.email "tu@email.com"
  ```
  Configura el correo electrónico del usuario.

### Iniciar un repositorio 📤 
- **Inicializar un nuevo repositorio:**
  ```
  git init
  ```
  Inicia un nuevo repositorio Git en el directorio actual.

### Trabajar con cambios locales 📝 
- **Agregar cambios al área de preparación:**
  ```
  git add nombre_del_archivo
  ```
  Agrega cambios al área de preparación.

- **Confirmar cambios:**
  ```
  git commit -m "Mensaje descriptivo"
  ```
  Confirma los cambios con un mensaje descriptivo.

- **Ver el estado de los archivos:**
  ```
  git status
  ```
  Muestra el estado actual de los archivos en el repositorio.

### Ramas (Branches) 🌿
- **Crear una nueva rama:**
  ```
  git branch nombre_de_la_rama
  ```
  Crea una nueva rama.

- **Cambiar a una rama específica:**
  ```
  git checkout nombre_de_la_rama
  ```
  Cambia al estado de una rama específica.

- **Crear y cambiar a una nueva rama:**
  ```
  git checkout -b nombre_de_la_rama
  ```
  Crea y cambia a una nueva rama en un solo paso.

### Fusionar cambios 🔀 
- **Fusionar una rama en la rama actual:**
  ```
  git merge nombre_de_la_rama
  ```
  Fusiona los cambios de una rama en la rama actual.

### Trabajar con repositorios remotos 📥
- **Clonar un repositorio remoto:**
  ```
  git clone url_del_repositorio
  ```
  Clona un repositorio remoto en el directorio actual.

- **Agregar un nuevo remoto:**
  ```
  git remote add nombre_remoto url_del_repositorio
  ```
  Agrega un nuevo repositorio remoto.

- **Obtener cambios del repositorio remoto:**
  ```
  git pull nombre_remoto nombre_rama
  ```
  Obtiene y fusiona cambios desde el repositorio remoto.

- **Enviar cambios al repositorio remoto:**
  ```
  git push nombre_remoto nombre_rama
  ```
  Envía cambios al repositorio remoto.

Mas comandos en: [documentación oficial de Git](https://git-scm.com/doc).
