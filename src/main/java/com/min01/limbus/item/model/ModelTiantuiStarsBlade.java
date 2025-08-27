package com.min01.limbus.item.model;

import java.util.List;

import com.min01.limbus.LimbusCompany;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ModelTiantuiStarsBlade extends Model
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LimbusCompany.MODID, "tiantui_stars_blade"), "main");
	private final ModelPart sowrd;
	private final ModelPart bone10;
	private final ModelPart Slash2;
	private final ModelPart Slash;
	private final ModelPart bone13;
	private final ModelPart bone16;
	private final ModelPart bone17;
	private final ModelPart bone18;
	private final ModelPart bone19;
	private final ModelPart bone20;
	
	private final List<ModelPart> flameParts;

	public ModelTiantuiStarsBlade(ModelPart root)
	{
		super(RenderType::entityCutoutNoCull);
		this.sowrd = root.getChild("sowrd");
		this.bone10 = this.sowrd.getChild("bone10");
		this.Slash2 = this.bone10.getChild("Slash2");
		this.Slash = this.bone10.getChild("Slash");
		this.bone13 = this.bone10.getChild("bone13");
		this.bone16 = this.bone10.getChild("bone16");
		this.bone17 = this.bone10.getChild("bone17");
		this.bone18 = this.bone10.getChild("bone18");
		this.bone19 = this.bone10.getChild("bone19");
		this.bone20 = this.bone10.getChild("bone20");
		this.flameParts = List.of(this.bone13, this.bone16, this.bone17, this.bone18, this.bone19, this.bone20);
	}

	public static LayerDefinition createBodyLayer() 
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sowrd = partdefinition.addOrReplaceChild("sowrd", CubeListBuilder.create().texOffs(21, 133).addBox(-0.5F, -1.5F, 8.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.04F))
		.texOffs(31, 105).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.04F))
		.texOffs(75, 132).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F))
		.texOffs(79, 105).addBox(0.0F, -3.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 12.0F));

		PartDefinition bone10 = sowrd.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(143, 150).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 132).addBox(-1.0F, 1.0F, -6.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(82, 155).addBox(-2.5F, -2.0F, -5.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 173).addBox(0.0F, -9.0F, -52.0F, 0.0F, 13.0F, 46.0F, new CubeDeformation(0.0F))
		.texOffs(140, 83).addBox(-1.0F, -4.0F, -12.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(140, 83).addBox(-1.0F, -4.0F, -17.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -5.0F, -23.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-1.0F, -4.0F, -29.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -5.0F, -35.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-1.0F, -7.0F, -41.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(82, 155).mirror().addBox(0.5F, -2.0F, -5.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, -6.0F));

		bone10.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 159).addBox(0.0F, 1.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		bone10.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 155).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 0.3491F, 0.0F, 0.0F));

		bone10.addOrReplaceChild("Slash2", CubeListBuilder.create().texOffs(178, 131).addBox(0.0F, -45.0F, -15.0F, 0.0F, 45.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -30.0F));

		bone10.addOrReplaceChild("Slash", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -62.0F, -15.0F, 0.0F, 62.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -30.0F));

		bone10.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -40.0F));

		bone10.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -34.0F));

		bone10.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -28.0F));

		bone10.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -22.0F));

		bone10.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -16.0F));

		bone10.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(66, 105).addBox(0.0F, -20.0F, -4.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -11.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) 
	{
		this.Slash.visible = false;
		this.Slash2.visible = false;
		this.flameParts.forEach(t -> t.visible = false);
		sowrd.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}