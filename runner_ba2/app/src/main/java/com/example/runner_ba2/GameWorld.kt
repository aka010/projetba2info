package com.example.runner_ba2

//Classe représentant le monde du jeu.*/
class GameWorld {
    // Attributs
    private val lanes: List<Lane> = listOf() // Liste des voies du jeu
    private val obstacleManager: ObstacleManager = ObstacleManager()
    private var difficultyLevel: Int = 1 // Niveau de difficulté initial
    var obstacleScrollSpeed = 5f
    //Mise à jour du monde du jeu.*/
    fun update(game: Game) {
        println("Mise à jour du GameWorld")// Mettre à jour les obstacles
        obstacleScrollSpeed += 0.01f
        obstacleManager.obstacleScrollSpeed = obstacleScrollSpeed
        obstacleManager.updateObstacles(game)

        // Vérifier si le niveau de difficulté doit augmenter
        increaseDifficulty()
        obstacleScrollSpeed += 0.01f
    }

    //Génère des obstacles dans le monde du jeu.*/
    fun generateObstacles() {
        println("Génération des obstacles")
        obstacleManager.generateObstacles(difficultyLevel)}

    //Vérifie les collisions entre les objets du jeu (par exemple, joueur et obstacles).*/
    fun checkCollisions(player: Player): Boolean {
        println("Vérification des collisions")

        for (obstacle in obstacleManager.getObstacles()) {
            if (obstacle.isCollidingWithPlayer(player)) {
                println("Collision détectée avec un obstacle !")

                return true}}
        return false}

    /**

    Augmente la difficulté du jeu en fonction du temps ou des scores.*/
    fun increaseDifficulty() {
        println("Augmentation de la difficulté")// Exemple : Augmenter la difficulté toutes les 30 secondes
        difficultyLevel++
        obstacleManager.setDifficultyLevel(difficultyLevel)}

    fun getObstacleManager(): ObstacleManager {
        return obstacleManager
    }
}