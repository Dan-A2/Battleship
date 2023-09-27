package ir.sharif.ap.hw4.event;

import ir.sharif.ap.hw4.response.Response;

public interface EventVisitor {
    Response visitSignIn(SignInEvent event);

    Response visitSignUp(SignUpEvent event);

    Response showSpectate();

    Response goToMainMenu();

    Response clickBoard(ClickEvent event);

    Response getStatus();

    Response regenerateBoard();

    Response goToBoardCheck();

    Response readyPressed();

    Response getToken();

    Response showScoreboard();

    Response goToPersonal();

    Response spectateGame(SpectateGameEvent event);
}