package org.hexworks.zircon.api

import org.assertj.core.api.Assertions.assertThat
import org.hexworks.zircon.api.resource.BuiltInGraphicTilesetResource
import org.hexworks.zircon.api.resource.TilesetResource
import org.junit.Test

class GraphicTilesetResourcesTest {

    @Test
    fun shouldContainAllGraphicTilesets() {
        val fontCount = GraphicTilesetResources::class.members
                .filter { it.isFinal }
                .map { accessor ->
                    assertThat(accessor.call(GraphicTilesetResources))
                            .describedAs("Graphic Tileset: ${accessor.name}")
                            .isInstanceOf(TilesetResource::class.java)
                    1
                }.reduce(Int::plus)

        assertThat(fontCount).isEqualTo(ENUM_GRAPHIC_TILESETS.size)
    }

    companion object {
        val ENUM_GRAPHIC_TILESETS = BuiltInGraphicTilesetResource.values()
    }
}
