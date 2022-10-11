<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="刀具名称" prop="toolName">
      <el-input v-model="dataForm.toolName" placeholder="刀具名称"></el-input>
    </el-form-item>
    <el-form-item label="刀具直径" prop="toolAperture">
      <el-input v-model="dataForm.toolAperture" placeholder="刀具直径"></el-input>
    </el-form-item>
    <el-form-item label="刀具刃长" prop="edgeLength">
      <el-input v-model="dataForm.edgeLength" placeholder="刀具刃长"></el-input>
    </el-form-item>
    <el-form-item label="刀具寿命" prop="toolLife">
      <el-input v-model="dataForm.toolLife" placeholder="刀具寿命"></el-input>
    </el-form-item>
    <el-form-item label="刀尖距离" prop="noseLength">
      <el-input v-model="dataForm.noseLength" placeholder="刀尖距离"></el-input>
    </el-form-item>
    <el-form-item label="长度计初始读数" prop="lengthmeter">
      <el-input v-model="dataForm.lengthmeter" placeholder="长度计初始读数"></el-input>
    </el-form-item>
    <el-form-item label="刀库位置" prop="storehosePos">
      <el-input v-model="dataForm.storehosePos" placeholder="刀库位置"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          toolName: '',
          toolAperture: '',
          edgeLength: '',
          toolLife: '',
          noseLength: '',
          lengthmeter: '',
          storehosePos: ''
        },
        dataRule: {
          toolName: [
            { required: true, message: '刀具名称不能为空', trigger: 'blur' }
          ],
          toolAperture: [
            { required: true, message: '刀具直径不能为空', trigger: 'blur' }
          ],
          edgeLength: [
            { required: true, message: '刀具刃长不能为空', trigger: 'blur' }
          ],
          toolLife: [
            { required: true, message: '刀具寿命不能为空', trigger: 'blur' }
          ],
          noseLength: [
            { required: true, message: '刀尖距离不能为空', trigger: 'blur' }
          ],
          lengthmeter: [
            { required: true, message: '长度计初始读数不能为空', trigger: 'blur' }
          ],
          storehosePos: [
            { required: true, message: '刀库位置不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/coldextrusionholetool/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.toolName = data.coldExtrusionHoleTool.toolName
                this.dataForm.toolAperture = data.coldExtrusionHoleTool.toolAperture
                this.dataForm.edgeLength = data.coldExtrusionHoleTool.edgeLength
                this.dataForm.toolLife = data.coldExtrusionHoleTool.toolLife
                this.dataForm.noseLength = data.coldExtrusionHoleTool.noseLength
                this.dataForm.lengthmeter = data.coldExtrusionHoleTool.lengthmeter
                this.dataForm.storehosePos = data.coldExtrusionHoleTool.storehosePos
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/processParametersJqrzk/coldextrusionholetool/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'toolName': this.dataForm.toolName,
                'toolAperture': this.dataForm.toolAperture,
                'edgeLength': this.dataForm.edgeLength,
                'toolLife': this.dataForm.toolLife,
                'noseLength': this.dataForm.noseLength,
                'lengthmeter': this.dataForm.lengthmeter,
                'storehosePos': this.dataForm.storehosePos
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
