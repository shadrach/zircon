package org.codetome.zircon.input

import org.assertj.core.api.Assertions.assertThat
import org.codetome.zircon.Position
import org.junit.Test

class InputTest {

    @Test
    fun keyStrokeShouldBeKeyStroke() {
        assertThat(KeyStroke.EOF_STROKE.isKeyStroke()).isTrue()
    }

    @Test
    fun mouseActionShouldBeMouseAction() {
        assertThat(fetchMouseAction().isMouseAction()).isTrue()
    }

    @Test
    fun aMouseActionShouldHaveMouseActionInputType() {
        assertThat(fetchMouseAction().getInputType())
                .isEqualTo(InputType.MouseEvent)
    }

    @Test
    fun shouldProperlyReportInputType() {
        assertThat(KeyStroke.EOF_STROKE.inputTypeIs(InputType.EOF)).isTrue()
    }

    @Test
    fun shouldProperlyReportCtrlDown() {
        assertThat(KeyStroke(ctrlDown = true).isCtrlDown()).isTrue()
    }

    @Test
    fun shouldProperlyReportAltDown() {
        assertThat(KeyStroke(altDown = true).isAltDown()).isTrue()
    }

    @Test
    fun shouldProperlyReportShiftDown() {
        assertThat(KeyStroke(shiftDown = true).isShiftDown()).isTrue()
    }

    @Test
    fun shouldProperlyReportEventTime() {
        val expectedTime = System.currentTimeMillis()

        assertThat(KeyStroke(timestamp = expectedTime).getEventTime()).isEqualTo(expectedTime)
    }

    @Test
    fun shouldBeAbleToGetKeyStrokeAsKeyStroke() {
        val input: Input = KeyStroke.EOF_STROKE
        input.asKeyStroke()
    }

    @Test
    fun shouldBeAbleToGetMouseActionAsMouseAction() {
        val input: Input = MouseAction(MouseActionType.MOUSE_CLICKED, 1, Position.DEFAULT_POSITION)
        input.asMouseAction()
    }

    private fun fetchMouseAction(): MouseAction {
        return MouseAction(
                actionType = MouseActionType.MOUSE_WHEEL_ROTATED_UP,
                button = 1,
                position = Position.DEFAULT_POSITION
        )
    }

}