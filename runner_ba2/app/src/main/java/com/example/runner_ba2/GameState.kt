package com.example.runner_ba2

//Interface représentant un état de jeu.*/
interface GameState {
    //Méthode appelée pour mettre à jour l'état du jeu.*/
    fun update()

    /**

    Méthodes pour gérer les transitions d'état.*/
    fun enter()
    fun exit()
    fun handleInput(input: Input)
}