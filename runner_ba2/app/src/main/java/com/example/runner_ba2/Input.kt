package com.example.runner_ba2

/*

Types d'entrées possibles dans le jeu*/
enum class InputType {
    LEFT,       // Déplacement à gauche
    RIGHT,      // Déplacement à droite
    UP,         // Navigation vers le haut (menu)
    DOWN,       // Navigation vers le bas (menu)
    SELECT,     // Sélection (menu)
    PAUSE,      // Pause du jeu
    RESUME,     // Reprise du jeu
    RESTART,    // Redémarrage du jeu
    MENU,       // Retour au menu
    QUIT        // Quitter le jeu
}

/*

Classe représentant une entrée utilisateur*/
class Input(val type: InputType) {
    override fun toString(): String {
        return "Input(type=$type)"
    }
}