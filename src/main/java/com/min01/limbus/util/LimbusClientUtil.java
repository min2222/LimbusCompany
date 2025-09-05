package com.min01.limbus.util;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class LimbusClientUtil 
{
	public static final Minecraft MC = Minecraft.getInstance();
	
    public static void drawQuad(PoseStack stack, VertexConsumer consumer, float size, float ySize, int packedLightIn) 
    {
        float minU = 0;
        float minV = 0;
        float maxU = 1;
        float maxV = 1;
        PoseStack.Pose matrixstack$entry = stack.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        drawVertex(matrix4f, matrix3f, consumer, size, ySize, 0, minU, minV, 1.0F, packedLightIn);
        drawVertex(matrix4f, matrix3f, consumer, size, -ySize, 0, minU, maxV, 1.0F, packedLightIn);
        drawVertex(matrix4f, matrix3f, consumer, -size, -ySize, 0, maxU, maxV, 1.0F, packedLightIn);
        drawVertex(matrix4f, matrix3f, consumer, -size, ySize, 0, maxU, minV, 1.0F, packedLightIn);
    }
    
    public static void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureX, float textureY, float alpha, int packedLightIn)
    {
    	vertexBuilder.vertex(matrix, offsetX, offsetY, offsetZ).color(1, 1, 1, 1 * alpha).uv(textureX, textureY).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLightIn).normal(normals, 0.0F, 1.0F, 0.0F).endVertex();
    }
}
